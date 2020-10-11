# CovidAid Backend API Documentation

Unless specified otherwise, the 'good' response (everything went well)
is:

```json
{"status": "OK"}
```

All responses, errors or otherwise have an appropriate HTTP status code.
Infer accordingly. You might chance up on some other...undocumented
responses. Usage of your graymatter expected, in such cases.

### `POST /signup`

Send:
```json
{
	"email":"john.doe@service.com",
	"first_name":"John",
	"last_name":"Doe",
	"contact_number":"+919191919191",
	"password":"very_secure_password"
}
```

### `POST /login`

Send:
```json
{
	"email":"john.doe@service.com",
	"password":"very_secure_password"
}
```

### `POST /logout`

Send:
Nothing, just call the route

### `POST /new_request`

Send:
```json
{
	"name": "Dr. Manhattan",
	"contact_number": "+919191919191",
	"location": "Mars",
	"address": "Giant glass structure, near the crater",
	"subject": "Need help with architecture design",
	"description": "I'm alone here and it would be nice to have a friend"
}
```

### `POST /all_requests`

Send:
```json
{
	#Optional
	"location": "Mars"
}
```

Receive if **optional "location" was sent**:

```json
{
	#Requests, location wise
	...
}
```

Receive if called directly:

```json
{
	#All Requests
	...
}
```


### `POST /request_info`

Send:
```json
{
	"request_id": 1
}
```

Receive, if **request does not exist**
```json
{"status": "error", "msg": "Request does not exist!"}
```


### `POST /accept_request`

Send:
```json
{
	"request_id": 1,
	"helper_id": 2
}
```

Receive, if **request does not exist**
```json
{"status": "error", "msg": "Request does not exist!"}
```

### `POST /reject_request`

Send:
```json
{
	"request_id" 1
}
```

Receive, if **request hasn't been accepted**
```json
{"status": "error", "msg": "Only accepted requests can be rejected"}
```

### `POST /complete_request`

Send:
```json
{
	"request_id": 1
}
```

Receive, if **request hasn't been completed**
```json
{"status": "error", "msg": "Only accepted requests can be completed"}
```

### `POST /request_history`

Send:
Nothing, just call the route

### `POST /leaderboard`

Send:
Nothing, just call the route

