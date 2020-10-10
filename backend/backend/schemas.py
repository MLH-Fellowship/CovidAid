from .models import UserSchema, TaskSchema

user_schema = UserSchema(exclude=("id", "password_hash"))
tasks_schema = TaskSchema(exclude=("helper",), many=True)
