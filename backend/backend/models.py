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

    def set_password(self, password):
        self.password_hash = generate_password_hash(password)

    def check_password(self, password):
        return check_password_hash(self.password_hash, password)


# Schema
class UserSchema(ma.SQLAlchemyAutoSchema):
    class Meta:
        load_instance = True
        model = User
        include_relationships = True
        include_fk = True
