from flask import Flask
from werkzeug.security import generate_password_hash, check_password_hash
from flask_sqlalchemy import SQLAlchemy
from flask_migrate import Migrate
from flask import current_app as app
from flask_marshmallow import Marshmallow
from flask_login import UserMixin
from . import db

ma = Marshmallow(app)
migrate = Migrate(app, db, compare_type=True)

#  Models
class User(UserMixin, db.Model):
    __tablename__ = "users"

    id = db.Column(db.Integer, primary_key=True)
    first_name = db.Column(db.String(80), nullable=False)
    last_name = db.Column(db.String(80), nullable=False)
    email = db.Column(db.String(120), unique=True, nullable=False)
    password_hash = db.Column(db.String())
    contact_number = db.Column(db.String(20), unique=True, nullable=False)
    points = db.Column(db.Integer, default=0)

    def set_password(self, password):
        self.password_hash = generate_password_hash(password)

    def check_password(self, password):
        return check_password_hash(self.password_hash, password)


class Task(UserMixin, db.Model):
    __tablename__ = "tasks"

    id = db.Column(db.Integer, primary_key=True)
    name = db.Column(db.String(80), nullable=False)
    contact_number = db.Column(db.String(20), nullable=False)
    location = db.Column(db.String(80), nullable=False)
    address = db.Column(db.String(200), nullable=False)
    subject = db.Column(db.String(150), nullable=False)
    description = db.Column(db.String(250), nullable=False)
    help_seeker = db.Column(db.Integer, db.ForeignKey("users.id"), nullable=False)
    helper = db.Column(db.Integer, db.ForeignKey("users.id"), nullable=True)

    # waiting, accepted, cancelled and completed
    status = db.Column(db.String(30), default="waiting")


# Schema
class UserSchema(ma.SQLAlchemyAutoSchema):
    class Meta:
        load_instance = True
        model = User
        include_relationships = True
        include_fk = True


class TaskSchema(ma.SQLAlchemyAutoSchema):
    class Meta:
        load_instance = True
        model = Task
        include_relationships = True
        include_fk = True
