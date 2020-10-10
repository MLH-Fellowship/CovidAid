from flask import current_app as app
from flask import abort, request
from flask_login import LoginManager, current_user, login_user,login_required
from werkzeug.security import generate_password_hash
from .models import User
from . import db, login_manager
from .utils import bad, good
from .schemas import user_schema


@login_manager.user_loader
def load_user(id):
    return User.query.get(int(id))


@app.route("/signup", methods=["POST", "GET"])
def signup():
    if request.method == "GET":
        abort(404)

    if request.method == "POST":
        try:
            email = request.json["email"]
            first_name = request.json["first_name"]
            last_name = request.json["last_name"]
            contact_number = request.json["contact_number"]
        except KeyError:
            bad(
                "Error decoding JSON, ensure that the JSON has all the required fields"
            ), 400

        user = User(
            email=email,
            first_name=first_name,
            last_name=last_name,
            contact_number=contact_number,
        )
        user.set_password(request.json["password"])
        db.session.add(user)
        db.session.commit()
        return good("User registered!"), 200


@app.route("/login", methods=["POST", "GET"])
def register():
    if request.method == "GET":
        abort(404)

    if request.method == "POST":
        try:
            email = request.json["email"]
            password = request.json["password"]
        except KeyError:
            bad(
                "Error decoding JSON, ensure that the JSON has all the required fields"
            ), 400

        user = User.query.filter_by(email=email).first()

        if user is not None:
            if user.check_password(password):
                login_user(user)
                return good('Logged in!'), 200
            else:
                return bad('Incorrect Password!', 401)
        else:
            return bad('User does not exist!', 404)

@app.route("/logout", methods=["POST", "GET"])
@login_required
def logout():
    if request.method == "GET":
        abort(404)

    if request.method == "POST":
        logout_user()
        return good("User logged out!"), 200

@app.route("/profile", methods=["POST"])
@login_required
def profile():
    if(current_user is not None):
        return good(user_schema.dump(current_user)),200
    return bad("User does not exist!"), 400
