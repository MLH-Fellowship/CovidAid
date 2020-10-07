import os

SQLALCHEMY_DATABASE_URI = "postgresql:///covidaid"
SECRET_KEY = os.urandom(24)
SQLALCHEMY_TRACK_MODIFICATIONS = True
