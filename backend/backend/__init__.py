from flask import Flask
from flask_sqlalchemy import SQLAlchemy

db = SQLAlchemy()


def init_app():
    app = Flask(__name__)
    app.config.from_object("config")
    db.init_app(app)

    with app.app_context():
        db.create_all()
        from . import main

    return app
