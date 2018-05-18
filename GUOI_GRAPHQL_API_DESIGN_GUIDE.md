# Type's common fields
## id Field
Every type has a required system field with the name id of type ID. The id value of every node (regardless of the type) is globally unique and unambiguously identifies a node (as required by Relay). You cannot change the value for this field.
## createdAt and updatedAt Fields
Every type has the DateTime fields createdAt and updatedAt that will be set automatically when a node is created or updated. You cannot change the values for these fields.

# Query API Examples
## Fetch certain nodes of a specific type
   Query all Post nodes with a title that contains the string biggest:
```javascript
query {
  posts(filter: {
    title_contains: "biggest"
  }) {
    id
    title
    published
  }
}
```
# Query arguments
All queries and fields that return many nodes accept different query arguments to further control the query response. The response can be either of the following:
- ordered by field
- filtered by multiple fields
- paginated into multiple pages by fixing one specific node and either seeking forwards or backwards
These query arguments can be combined to achieve very specific query responses.

## Ordering by field
When querying all nodes of a model type you can supply the orderBy argument for every scalar field of the type: orderBy: <field>_ASC or orderBy: <field>_DESC.
- Order the list of all Post nodes ascending by title:
```javascript
query {
  posts(orderBy: title_ASC) {
    id
    title
    published
  }
}
```
- Order the list of all Post nodes descending by published:
```javascript
query {
  posts(orderBy: published_DESC) {
    id
    title
    published
  }
}
```

## Filtering by field
When querying all nodes of a type you can supply different parameters to the filter argument to filter the query response accordingly. The available options depend on the scalar fields defined on the type in question.
You can also include filters when including related fields in your queries to traverse your data graph.

**Applying single filters**

If you supply exactly one parameter to the filter argument, the query response will only contain nodes that adhere to this constraint.

**Filtering by value**

The easiest way to filter a query response is by supplying a field value to filter by.
Query all Post nodes that are not yet published:
```javascript
query {
  posts(filter: {
    published: false
  }) {
    id
    title
    published
  }
}
```

**Advanced filter criteria**

Depending on the type of the field you want to filter by, you have access to different advanced criteria you can use to filter your query response. See how to explore available filter criteria.
Query all Post nodes whose title is in a given list of strings:
```javascript
query {
  posts(filter: {
    title_in: ["My biggest Adventure", "My latest Hobbies"]
  }) {
    id
    title
    published
  }
}
```

**Relation filters**

For to-one relations, you can define conditions on the related node by nesting the according argument in filter

Query all Post nodes where the author has the USER access role:
```javascript
query {
  posts(filter: {
    author: {
      accessRole: USER
    }
  }) {
    title
  }
}

```

**Combining multiple filters**

You can use the filter combinators OR and AND to create an arbitrary logical combination of filter conditions.

- **Using OR or AND**

Let's start with an easy example:
Query all Post nodes that are published and whose title is in a given list of strings:
```javascript
query {
  posts(filter: {
    AND: [{
      title_in: ["My biggest Adventure", "My latest Hobbies"]
    }, {
      published: true
    }]
  }) {
    id
    title
    published
  }
}
```

- **Arbitrary combination of filters with AND and OR**

You can combine and even nest the filter combinators AND and OR to create arbitrary logical combinations of filter conditions.
Query all Post nodes that are either published and whose title is in a list of given strings, or have the specific id we supply:
```javascript
query($published: Boolean) {
  posts(filter: {
    OR: [{
      AND: [{
        title_in: ["My biggest Adventure", "My latest Hobbies"]
      }, {
        published: $published
      }]
    }, {
      id: "cixnen24p33lo0143bexvr52n"
    }]
  }) {
    id
    title
    published
  }
}
```

# Define query filter guide
Apart from the filter combinators AND and OR, the available filter arguments for a query for all nodes of a type depend on the fields of the type and their types.
Let's consider the following schema:
```javascript
type Meta {
  id: ID! @isUnique
  text: String!
  number: Int!
  decimal: Float!
  flag: Boolean!
  date: DateTime!
  enum: SomeEnum!
  object: Json!
}
```

Based on this type, a MetaFilter type will be defined with the following fields, grouped by field type.
```javascript
input MetaFilter {
  # logical operators
  AND: [MetaFilter!] # combines all passed `MetaFilter` objects with logical AND
  OR: [MetaFilter!] # combines all passed `MetaFilter` objects with logical OR

  # DateTime filters
  createdAt: DateTime # matches all nodes with exact value
  createdAt_not: DateTime # matches all nodes with different value
  createdAt_in: [DateTime!] # matches all nodes with value in the passed list
  createdAt_not_in: [DateTime!] # matches all nodes with value not in the passed list
  createdAt_lt: DateTime # matches all nodes with lesser value
  createdAt_lte: DateTime # matches all nodes with lesser or equal value
  createdAt_gt: DateTime # matches all nodes with greater value
  createdAt_gte: DateTime # matches all nodes with greater or equal value

  # Float filters
  decimal: Float # matches all nodes with exact value
  decimal_not: Float # matches all nodes with different value
  decimal_in: [Float!] # matches all nodes with value in the passed list
  decimal_not_in: [Float!] # matches all nodes with value not in the passed list
  decimal_lt: Float # matches all nodes with lesser value
  decimal_lte: Float # matches all nodes with lesser or equal value
  decimal_gt: Float # matches all nodes with greater value
  decimal_gte: Float # matches all nodes with greater or equal value

  # Enum filters
  enum: META_ENUM # matches all nodes with exact value
  enum_not: META_ENUM # matches all nodes with different value
  enum_in: [META_ENUM!] # matches all nodes with value in the passed list
  enum_not_in: [META_ENUM!] # matches all nodes with value not in the passed list

  # Boolean filters
  flag: Boolean # matches all nodes with exact value
  flag_not: Boolean # matches all nodes with different value

  # ID filters
  id: ID # matches all nodes with exact value
  id_not: ID # matches all nodes with different value
  id_in: [ID!] # matches all nodes with value in the passed list
  id_not_in: [ID!] # matches all nodes with value not in the passed list
  id_lt: ID # matches all nodes with lesser value
  id_lte: ID # matches all nodes with lesser or equal value
  id_gt: ID # matches all nodes with greater value
  id_gte: ID # matches all nodes with greater or equal value
  id_contains: ID # matches all nodes with a value that contains given substring
  id_not_contains: ID # matches all nodes with a value that does not contain given substring
  id_starts_with: ID # matches all nodes with a value that starts with given substring
  id_not_starts_with: ID # matches all nodes with a value that does not start with given substring
  id_ends_with: ID # matches all nodes with a value that ends with given substring
  id_not_ends_with: ID # matches all nodes with a value that does not end with given substring

  # Int filters
  number: Int # matches all nodes with exact value
  number_not: Int # matches all nodes with different value
  number_in: [Int!] # matches all nodes with value in the passed list
  number_not_in: [Int!] # matches all nodes with value not in the passed list
  number_lt: Int # matches all nodes with lesser value
  number_lte: Int # matches all nodes with lesser or equal value
  number_gt: Int # matches all nodes with greater value
  number_gte: Int # matches all nodes with greater or equal value

  # String filters
  text: String # matches all nodes with exact value
  text_not: String # matches all nodes with different value
  text_in: [String!] # matches all nodes with value in the passed list
  text_not_in: [String!] # matches all nodes with value not in the passed list
  text_lt: String # matches all nodes with lesser value
  text_lte: String # matches all nodes with lesser or equal value
  text_gt: String # matches all nodes with greater value
  text_gte: String # matches all nodes with greater or equal value
  text_contains: String # matches all nodes with a value that contains given substring
  text_not_contains: String # matches all nodes with a value that does not contain given substring
  text_starts_with: String # matches all nodes with a value that starts with given substring
  text_not_starts_with: String # matches all nodes with a value that does not start with given substring
  text_ends_with: String # matches all nodes with a value that ends with given substring
  text_not_ends_with: String # matches all nodes with a value that does not end with given substring
}
```

## Pagination
When querying all nodes of a specific model type, you can supply arguments that allow you to paginate the query response.

Pagination allows you to request a certain amount of nodes at the same time. You can seek forwards or backwards through the nodes and supply an optional starting node:

- to seek forwards, use first; specify a starting node with after.
- to seek backwards, use last; specify a starting node with before.

You can also skip an arbitrary amount of nodes in whichever direction you are seeking by supplying the skip argument.
Consider a blog where only 3 Post nodes are shown at the front page. To query the first page:
```javascript
query {
  posts(first: 3) {
    id
    title
  }
}
```

To query the first two Post node after the first Post node:
```javascript
query {
  posts(
    first: 2
    after: "cixnen24p33lo0143bexvr52n"
  ) {
    id
    title
  }
}
```

Query the last 2 posts:
```javascript
query {
  posts(last: 2) {
    id
    title
  }
}

```

> Note: You cannot combine first with before or last with after. If you query more nodes than exist, your response will simply contain all nodes that actually do exist in that direction.

# About mutations
To form a mutation, you must specify three things:

>1. Mutation name. The type of modification you want to perform.
>2. Input object. The data you want to send to the server, composed of input fields. Pass it as an argument to the mutation name.
>3. Payload object. The data you want to return from the server, composed of return fields. Pass it as the body of the mutation name.
Mutations are structured like this:
```javascript
mutation {
  mutationName(input: {MutationNameInput!}) {
    MutationNamePayload
}
```
The input object in this example is `MutationNameInput`, and the payload object is `MutationNamePayload`.

In the mutations reference, the listed input fields are what you pass as the input object. The listed return fields are what you pass as the payload object.

## Example mutation
   Mutations often require information that you can only find out by performing a query first. This example shows two operations:
   
>1. A query to get an issue ID.
>2. A mutation to add an emoji reaction to the issue.
```javascript
query FindIssueID {
  repository(owner:"octocat", name:"Hello-World") {
    issue(number:349) {
      id
    }
  }
}

mutation AddReactionToIssue {
  addReaction(input:{subjectId:"MDU6SXNzdWUyMzEzOTE1NTE=",content:HOORAY}) {
    reaction {
      content
    }
    subject {
      id
    }
  }
}
```
## Refer to [https://developer.github.com/v4/guides/forming-calls/#example-mutation](https://developer.github.com/v4/guides/forming-calls/#example-mutation)

# Pagination
> In general, we've found that cursor-based pagination is the most powerful of those designed. Especially if the cursors are opaque, either offset or ID-based pagination can be implemented `using cursor-based pagination` (by making the cursor the offset or the ID), and using cursors gives additional flexibility if the pagination model changes in the future. As a reminder that the cursors are opaque and that their format should not be relied upon, we suggest `base64 encoding` them.

>  Pagination allows you to request a certain amount of nodes at the same time. You can seek forwards or backwards through the nodes and supply an optional starting node:
   - to seek forwards, use first; specify a starting node with after.
   - to seek backwards, use last; specify a starting node with before.
```javascript
# A list of hello.
  hellos(

    # Returns the elements in the list that come after the specified global ID.
    after: String

    # Returns the elements in the list that come before the specified global ID.
    before: String

    # Returns the first _n_ elements from the list.
    first: Int

    # Returns the last _n_ elements from the list.
    last: Int

    # Skip the _n_ elements from the list.
    skip: Int

    # Filter condition
    filter: HelloFilterInput

    # Order options for hellos return from the connection
    orderBy: HelloOrderByInput

  ): HelloConnection!

```