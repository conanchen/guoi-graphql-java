package com.github.conanchen.guoi.graphql.util;

import com.google.common.base.Ascii;
import com.google.common.base.Converter;

import javax.annotation.Nullable;
import java.io.Serializable;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author hai
 * description 简单的convert实现
 * email hilin2333@gmail.com
 * date 2018/5/16 6:48 AM
 */
public enum PrincipleFormat {

    /**
     * grpc principle 'name,namePerson
     */
    NAME() {

        @Override
        String convert(PrincipleFormat format, String s) {
            if (format == ID) {
                return (s.isEmpty())
                        ? s
                        : s.equals(GRPC_NMAE)
                        ? GENERIC_ID
                        : s.startsWith(GRPC_NMAE)
                        ? Ascii.toLowerCase(s.charAt(GRPC_NMAE.length())) +
                        s.substring(GRPC_NMAE.length() + 1, s.length())
                        + ENDWITH_GENERIC_ID
                        : s;

            }
            return s;
        }
    },

    /**
     * java principle 'id,personId'
     */
    ID() {

        @Override
        String convert(PrincipleFormat format, String s) {
            if (format == NAME) {
                return (s.isEmpty())
                        ? s
                        : s.equals(GENERIC_ID)
                        ? GRPC_NMAE
                        : s.startsWith(GENERIC_ID)
                        ? GRPC_NMAE + "_" + s.substring(0, s.length() - 2)
                        : s;
            }
            return s;
        }
    },
    ;

    private static final String GRPC_NMAE = "name";
    private static final String GENERIC_ID = "id";
    private static final String ENDWITH_GENERIC_ID = "Id";

    PrincipleFormat() {
    }

    public final String to(PrincipleFormat format, String str) {
        checkNotNull(format);
        checkNotNull(str);
        return (format == this) ? str : convert(format, str);
    }


    abstract String convert(PrincipleFormat format, String s);


    public Converter<String, String> converterTo(PrincipleFormat targetFormat) {
        return new IDConverter(this, targetFormat);
    }

    private static final class IDConverter extends Converter<String, String>
            implements Serializable {

        private final PrincipleFormat sourceFormat;
        private final PrincipleFormat targetFormat;

        IDConverter(PrincipleFormat sourceFormat, PrincipleFormat targetFormat) {
            this.sourceFormat = checkNotNull(sourceFormat);
            this.targetFormat = checkNotNull(targetFormat);
        }

        @Override
        protected String doForward(String s) {
            return sourceFormat.to(targetFormat, s);
        }

        @Override
        protected String doBackward(String s) {
            return targetFormat.to(sourceFormat, s);
        }

        @Override
        public boolean equals(@Nullable Object object) {
            if (object instanceof IDConverter) {
                IDConverter that = (IDConverter) object;
                return sourceFormat.equals(that.sourceFormat) && targetFormat.equals(that.targetFormat);
            }
            return false;
        }

        @Override
        public int hashCode() {
            return sourceFormat.hashCode() ^ targetFormat.hashCode();
        }

        @Override
        public String toString() {
            return sourceFormat + ".converterTo(" + targetFormat + ")";
        }

        private static final long serialVersionUID = 0L;
    }

}