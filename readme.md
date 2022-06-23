# Student Simple API

## Base url

```
https://student-api-bootcamp.herokuapp.com/v1
```

## Table endpoints
### Student

| Name                       | Endpoint                                                   | Method   | Body and response              |
|----------------------------|------------------------------------------------------------|----------|--------------------------------|
| Get all                    | `/student`                                                 | `GET`    | [example](#student---get-all)  |
| Get by id                  | `/student/{id}`                                            | `GET`    | [example](#student---by-id)   |
| Add new                    | `/student`                                                 | `POST`   | [example](#student---add-new) |
| Update                     | `/student`                                                 | `PUT`    | [example](#student---update)  |
| Remove                     | `/student`                                                 | `DELETE` | [example](#student---remove)  |

---

## Student Examples
### Student - Get All

```
GET /student
```

Response

```json
{
  "status": true,
  "message": "OK",
  "data": [
    {
      "id": "2a6e0a8a-ff6c-4a76-b50d-2d3ccaf61b57",
      "name": "Budi",
      "gender": "Laki - Laki",
      "className": "IPA 1"
    },
    {
      "id": "878a4841-0d21-4740-9e31-cf2db5e13328",
      "name": "Ferrian",
      "gender": "Laki - Laki",
      "className": "IPA 3"
    }
  ]
}
```

### Student - Get By Id

```
GET /student/{id}
```

Response

```json
{
  "status": true,
  "message": "OK",
  "data": {
    "id": "878a4841-0d21-4740-9e31-cf2db5e13328",
    "name": "Ferrian",
    "gender": "Laki - Laki",
    "className": "IPA 3"
  }
}
```

### Student - Add New

```
POST /student
```

Body

```json
{
  "name" : "Jamet",
  "gender" : "Laki - Laki",
  "className" : "IPA 4"
}
```

Response

```json
{
  "status": true,
  "message": "OK",
  "data": [
    {
      "id": "2a6e0a8a-ff6c-4a76-b50d-2d3ccaf61b57",
      "name": "Budi",
      "gender": "Laki - Laki",
      "className": "IPA 1"
    },
    {
      "id": "878a4841-0d21-4740-9e31-cf2db5e13328",
      "name": "Ferrian",
      "gender": "Laki - Laki",
      "className": "IPA 3"
    },
    {
      "id": "e9e91979-6444-4f30-97b1-1a71a3dc05b4",
      "name": "Jamet",
      "gender": "Laki - Laki",
      "className": "IPA 4"
    }
  ]
}
```

### Student - Update

```
PUT /student
```
Body

```json
{
  "name" : "Jamet",
  "gender" : "Laki - Laki",
  "className" : "IPA 4"
}
```

Response

```json
{
  "status": true,
  "message": "OK",
  "data": {
    "id": "878a4841-0d21-4740-9e31-cf2db5e13328",
    "name": "Ferrian",
    "gender": "Laki - Laki",
    "className": "IPA 6"
  }
}
```

### Student - Remove

```
DELETE /student/{id}
```

Response

```json
{
  "status": true,
  "message": "OK",
  "data": [
    {
      "id": "2a6e0a8a-ff6c-4a76-b50d-2d3ccaf61b57",
      "name": "Budi",
      "gender": "Laki - Laki",
      "className": "IPA 1"
    },
    {
      "id": "878a4841-0d21-4740-9e31-cf2db5e13328",
      "name": "Ferrian",
      "gender": "Laki - Laki",
      "className": "IPA 6"
    }
  ]
}
```
