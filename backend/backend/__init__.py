from flask import Flask
from flask_login import LoginManager
from flask_sqlalchemy import SQLAlchemy

db = SQLAlchemy()
login_manager = LoginManager()


def init_app():
    app = Flask(__name__)
    app.config.from_object("config")
    db.init_app(app)
    login_manager.init_app(app)
    login_manager.session_protection = "strong"

    with app.app_context():
        db.create_all()
        from . import main

    return app
