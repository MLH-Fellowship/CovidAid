from flask import Flask
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
    first_name = db.Column(db.String(80), unique=True, nullable=False)
    last_name = db.Column(db.String(80), unique=True, nullable=False)
    email = db.Column(db.String(120), unique=True, nullable=False)
    password = db.Column(db.String(), nullable=False)
    contact_number = db.Column(db.String(12), unique=True, nullable=False)


# Schema
class UserSchema(ma.SQLAlchemyAutoSchema):
    class Meta:
        load_instance = True
        model = User
        include_relationships = True
        include_fk = True
