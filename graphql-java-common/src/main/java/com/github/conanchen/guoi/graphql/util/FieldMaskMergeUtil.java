package com.github.conanchen.guoi.graphql.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.protobuf.Descriptors;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Message;
import com.google.protobuf.Timestamp;
import com.google.protobuf.util.Timestamps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.PropertyDescriptor;
import java.util.*;

public class FieldMaskMergeUtil<T> {

    private static  final Gson gson = new GsonBuilder().create();
    public static final com.google.common.base.Converter<String, String> DEFAULT_CONVERTER = PrincipleFormat.NAME.converterTo(PrincipleFormat.ID);

    private static final Logger logger = LoggerFactory.getLogger(FieldMaskMergeUtil.class);
    public FieldMaskMergeUtil(FieldMask mask) {
        mergeFromFieldMask(mask);
        this.converter = DEFAULT_CONVERTER;
    }
    public FieldMaskMergeUtil(FieldMask mask,com.google.common.base.Converter<String, String>  converter) {
        mergeFromFieldMask(mask);
        this.converter = converter;
    }
    private static final String FIELD_PATH_SEPARATOR_REGEX = "\\.";


    private static final class Node {
        final SortedMap<String, Node> children = new TreeMap<String, Node>();
    }

    private final Node root = new Node();

    private final com.google.common.base.Converter<String, String> converter;

    FieldMaskMergeUtil mergeFromFieldMask(FieldMask mask) {
        for (String path : mask.getPathsList()) {
            addFieldPath(path);
        }
        return this;
    }

    /**
     * Adds a field path to the tree. In a FieldMask, every field path matches the
     * specified field as well as all its sub-fields. For example, a field path
     * "foo.bar" matches field "foo.bar" and also "foo.bar.baz", etc. When adding
     * a field path to the tree, redundant sub-paths will be removed. That is,
     * after adding "foo.bar" to the tree, "foo.bar.baz" will be removed if it
     * exists, which will turn the tree node for "foo.bar" to a leaf node.
     * Likewise, if the field path to add is a sub-path of an existing leaf node,
     * nothing will be changed in the tree.
     */
    FieldMaskMergeUtil addFieldPath(String path) {
        String[] parts = path.split(FIELD_PATH_SEPARATOR_REGEX);
        if (parts.length == 0) {
            return this;
        }
        Node node = root;
        boolean createNewBranch = false;
        // Find the matching node in the tree.
        for (String part : parts) {
            // Check whether the path matches an existing leaf node.
            if (!createNewBranch && node != root && node.children.isEmpty()) {
                // The path to add is a sub-path of an existing leaf node.
                return this;
            }
            if (node.children.containsKey(part)) {
                node = node.children.get(part);
            } else {
                createNewBranch = true;
                Node tmp = new Node();
                node.children.put(part, tmp);
                node = tmp;
            }
        }
        // Turn the matching node into a leaf node (i.e., remove sub-paths).
        node.children.clear();
        return this;
    }
    /**
     * Merges all fields specified by this FieldMaskTree from {@code source} to {@code destination}.
     */
    public T merge(Message source, String prefix,Object obj){
        try {
            if (root.children.isEmpty() || obj.getClass()
                    .getDeclaredFields().length < 1 || root.children.get(prefix) == null){
                throw new IllegalArgumentException("the field mask must have paths");
            }
            Message.Builder builder = source.toBuilder();
            Descriptors.Descriptor descriptor = source.getDescriptorForType();
            Descriptors.FieldDescriptor field = descriptor.findFieldByName(prefix);
            if (field == null){
                throw new IllegalArgumentException("the field mask must have paths");
            }
            return (T)merge(root.children.get(prefix), prefix, (Message) builder.getField(field), obj);
        } catch (InstantiationException e) {
            logger.error("无默认构造方法",e);
        } catch (IllegalAccessException e) {
            logger.error("默认构造方法非public",e);
        }
        return null;
    }
    /**
     * Merges all fields specified by this FieldMaskTree from {@code source} to {@code destination}.
     */
    public T merge(Message source,Object obj){
        try {
            if (root.children.isEmpty() || obj.getClass()
                    .getDeclaredFields().length < 1){
                throw new IllegalArgumentException("the field mask must have paths");
            }
            return (T)merge(root, "", source, obj);
        } catch (InstantiationException e) {
            logger.error("无默认构造方法",e);
        } catch (IllegalAccessException e) {
            logger.error("默认构造方法非public",e);
        }
        return null;
    }

    /**
     * Merges all fields specified by this FieldMaskTree from {@code source} to {@code destination}.
     */
   public T merge(Message source, Class<T> cls){
       try {
           Object mongoBean = cls.newInstance();
           if (root.children.isEmpty() || cls.

                   getDeclaredFields().length < 1){
               throw new IllegalArgumentException("the field mask must have paths");
           }
           return (T)merge(root, "", source, mongoBean);
       } catch (InstantiationException e) {
          logger.error("无默认构造方法",e);
       } catch (IllegalAccessException e) {
           logger.error("默认构造方法非public",e);
       }
       return null;
    }

    /**
     * Merges all fields specified by this FieldMaskTree from {@code source} to {@code destination}.
     */
    public T merge(Message source, String prefix, Class<T> cls){
        try {
            if (root.children.isEmpty() || cls
                    .getDeclaredFields().length < 1 || root.children.get(prefix) == null){
                throw new IllegalArgumentException("the field mask must have paths");
            }
            Message.Builder builder = source.toBuilder();
            Descriptors.Descriptor descriptor = source.getDescriptorForType();
            Descriptors.FieldDescriptor field = descriptor.findFieldByName(prefix);
            if (field == null){
                throw new IllegalArgumentException("the field mask must have paths");
            }
            Object mongoBean = cls.newInstance();

            return (T)merge(root.children.get(prefix), prefix, (Message) builder.getField(field), mongoBean);
        } catch (InstantiationException e) {
            logger.error("无默认构造方法",e);
        } catch (IllegalAccessException e) {
            logger.error("默认构造方法非public",e);
        }
        return null;
    }

    /**
     * Merges all fields specified by a sub-tree from {@code source} to {@code destination}.
     */
    private Object merge(
            Node node,
            String path,
            Message source,
            Object t) throws IllegalAccessException, InstantiationException {
        Descriptors.Descriptor descriptor = source.getDescriptorForType();
        for (Map.Entry<String, Node> entry : node.children.entrySet()) {
            Descriptors.FieldDescriptor field = descriptor.findFieldByName(entry.getKey());
            if (field == null) {
                logger.warn(
                        "Cannot find field \""
                                + entry.getKey()
                                + "\" in message type "
                                + descriptor.getFullName());
                continue;
            }
            String mongoFieldName = converter == null ? field.getJsonName() : converter.convert(field.getJsonName());
            PropertyDescriptor pd = PropertyUtil.getPropertyDescriptor(t.getClass(),mongoFieldName);
            //没有在父类中去找
            if (pd == null){
                pd = PropertyUtil.getPropertyDescriptor(t.getClass().getSuperclass(),mongoFieldName);
            }
            //有子项
            if (!entry.getValue().children.isEmpty()) {
                if (field.isRepeated() || field.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                    logger.warn(
                            "Field \""
                                    + field.getFullName()
                                    + "\" is not a "
                                    + "singluar message field and cannot have sub-fields.");
                    continue;
                }
                if (!source.hasField(field) || pd == null) {
                    continue;
                }
                if (pd.getPropertyType().getDeclaredFields().length < 1){
                    continue;
                }
                String childPath = path.isEmpty() ? entry.getKey() : path + "." + entry.getKey();
                Class clazz = pd.getPropertyType();
                Object obj = clazz.newInstance();
                merge(entry.getValue(),
                        childPath,
                        (Message) source.getField(field),
                        obj
                        );
                PropertyUtil.setProperty(t,obj,pd);
                continue;
            }
            if (field.isRepeated()) {
                for (Object element : (List) source.getField(field)) {
                    if (element.getClass().isSynthetic()){
                        Object obj = element.getClass().newInstance();
                        String childPath = path.isEmpty() ? entry.getKey() : path + "[x]." + entry.getKey();
                        merge(entry.getValue(),
                                childPath,
                                (Message) source.getField(field),
                                obj
                        );
                    }else{
                        PropertyUtil.setProperty(t,source.getField(field),pd);
                    }
                }
            } else {
                if (pd != null && pd.getPropertyType().isEnum() && field.getJavaType() == Descriptors.FieldDescriptor.JavaType.ENUM){
                    try {
                        Object o = pd.getPropertyType().getDeclaredMethod("valueOf", String.class).invoke(null, source.getField(field).toString());
                        PropertyUtil.setProperty(t, o, pd);
                    }catch (Exception e){
                        logger.warn("enum [{}] not found value [{}]",pd.getPropertyType(),source.getField(field).toString());
                    }
                }else{
                    if (pd != null  && field.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE){
                        PropertyUtil.setProperty(t, source.getField(field), pd);
                    }else if (pd != null
                            && field.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE
                            && ((Message)source.getField(field)).getDefaultInstanceForType().equals(source.getField(field))){
                        PropertyUtil.setProperty(t, (Object) null, pd);
                    }else if (source.getField(field).getClass().getName().equals(Timestamp.class.getName())
                            && pd.getPropertyType().getName().equals(Date.class.getName())) {
                        PropertyUtil.setProperty(t, new Date(Timestamps.toMillis((Timestamp) source.getField(field))), pd);
                    }
                }
            }
        }
        return t;
    }
}
