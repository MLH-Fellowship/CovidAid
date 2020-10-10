from .models import UserSchema, TaskSchema

users_schema = UserSchema(exclude=("password_hash",), many=True)
user_schema = UserSchema(exclude=("id", "password_hash"))
tasks_schema = TaskSchema(exclude=("helper",), many=True)
task_schema = TaskSchema()
