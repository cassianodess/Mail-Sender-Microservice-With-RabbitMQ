# Mail Sender Microservice

## [API link]()

## Specifications

### Send Email
### * URL: `/api/emails`
### * Method: `Post`
### * Body:

```
{
  "ownerRef": "<String>",
  "emailFrom": "<String>",
  "emailTo": "<String>",
  "subject": "<String>",
  "text": "<String>"
}
```
### * Response:

```
{
  "id": int,
  "ownerRef": "<String>",
  "emailFrom": "<String>",
  "emailTo": "<String>",
  "subject": "<String>",
  "text": "<String>",
  "sendDateTime": "<DateTimeLocal>",
  "statusEmail": <boolean>
}
```