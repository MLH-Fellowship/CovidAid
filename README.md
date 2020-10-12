<p align="center">
  <a href="#">
    <img src="https://github.com/NitishGadangi/CovidAid/blob/master/images/logo2.png?raw=true" alt="Logo" width="120" height="120">
  </a>

  <h3 align="center">CovidAid App</h3>

  <p align="center">
    A community driven platform where the users can request for help or engage with people who need help and then extend their help and support.
    <br />
    <a href="#download-from-here">Download</a>
    .
    <a href="https://github.com/NitishGadangi/CovidAid/issues">Report Bug</a>
    .
   <a href="#contribution">Contribute</a>
  
  <h4 align="center">Check out the Demo Video 📽 on <a href="">Youtube</a></h3>
  <h5 align="center">Made with ❤️ by  <a href="https://github.com/awalvie">Vishesh</a> , <a href="https://github.com/utsavcoding">Utsav</a> , <a href="https://nitishgadangi.github.io/">Nitish</a></h3>
  <h5 align="center">MLH Fellowship Pod 1.0.2</h3>
  </p>
</p>
</br>


## Inspiration
COVID19 has drastically affected people's lives around the globe. There are a lot of people in need of help but don't have a platform to effectively communicate their requests to the community around them. For people affected by the virus it becomes twice as worse because they would be in isolation and cannot communicate if they are in need of help (which requires them to step out). This problem is compounded in smaller cities, where you usually don't have service for grocery or medicine delivery apps.

The objective with CovidAid is to facilitate the ease with which someone in need of help can request for help and can be helped out by others. It was our aim to recreate this sense of community within a digital world with dedicated functions for specific tasks so as to make the experience accessible to all.


## What it does
CovidAid is a community-driven platform for the people, where helpful people can locate the help-seeking people and fulfill their request with mutual consent, based on the location and proximity. It provides every user with basically two main roles,they can choose from:
1. **Ask for help** - This is for help-seekers. They can make requests by filling out details of what they would like help with and each new request is then posted onto a timeline for everyone to see.
2. **Like to help** - This is for people who would like to help. They will be presented with a number of active requests, which they can look through and accept as they see fit.

To make things interesting and track people's inherent kindness, we have also provided a leaderboard where users can check their _kindness points_, which is something you earn when you help others.

## Screenshots
![](https://github.com/NitishGadangi/CovidAid/blob/master/images/ss1.jpg?raw=true)
![](https://github.com/NitishGadangi/CovidAid/blob/master/images/ss2.jpg?raw=true)
![](https://github.com/NitishGadangi/CovidAid/blob/master/images/ss3.jpg?raw=true)

## How it was built

**Frontend**

The app is built using Android Native SDK tools with the following libraries
- **[ButterKnife](https://jakewharton.github.io/butterknife/)** - for View Binding
- **[Okhttp](https://square.github.io/okhttp/)** - as android Http Client
- **[OneSignal](https://onesignal.com/)** - Easy Firebase Notifications
- **[Gson](https://github.com/google/gson)** - to convert Java Objects into JSON and back
- **[TextFieldBoxes](https://github.com/HITGIF/TextFieldBoxes)** - Material EditText Views

**Backend**
- Poetry (dependency management)
- Flask (backend framework)
- PostgreSQL (relational database)
- SQLAlchemy (object relational mapper)
- Marshmallow (object serialization/de-serialization library)
- DigitalOcean (Virtual Machine hosting)
- Nginx (Interface for communication with the virtual machine)

## Challenges we ran into

**Frontend**

1. Keeping the UI lucid and intuitive as our motto is to help people, especially the older people.
2. Implementing the login functionality using Flask-Login by making use of sessions.

**Backend**

1. Setting up flask. There's a lot of ways to set up the flask directory structure, so finding the balance between simple and sensible was a little difficult.
2. Writing the API documentation. We originally wanted to have auto-generated documentation with say Sphinx or Swagger, but found it cumbersome and difficult, so instead we just wrote it by hand. But we did set both up just to learn how to do it.
3. Deploying the server on a Virtual Machine and allow communication between the frontend and backend was a little challenging as we could not figure out how to configure Nginx properly and had to dig through the documentation to find the correct options.

## Accomplishments that we're proud of

- Coming up with a solution to situational problem which helps our community.
- Collaborating with each other on a regular basis, ensuring that we are on the same page throughout the hackathon.

## What we learnt

- How to setup a sensible project structure with Flask.
- Learnt to implement REST APIs for backend services using Flask.
- Also learnt to use SQLAlchemy as the ORM tool, which makes it easy to work with database.
- How to test your APIs with httpie
- How to use the GitHub workflow for keeping track of issues, branches, PRs and project board.
- How to deploy the backend on a Virtual Machine and allow communication between the backend and frontend.

## What's next for CovidAid

- Implement notifications for the users whenever helper accept the request to help-seekers. This notification will be triggered for both the parties.
- Provide a feedback form when requests are completed.
- If multiple helpers accept a request, give the help-seeker the option to choose, using star ratings.
- Add options to filter and search for the Help Requests, based on geographic location.

## Download from here:

**Will be available on Playstore Soon**
  
<h4>You can access all the releases from <a href="https://github.com/NitishGadangi/CovidAid/releases">Releases tab</a></h3>

## Contribution
**Contributions are always welcome 💕**

Follow [instructions mentioned here](https://github.com/NitishGadangi/CovidAid/tree/master/App) to setup Environment get started with App development.

Also, You can use [these instructions](https://github.com/NitishGadangi/CovidAid/tree/master/backend) to setup environment for Backend development.

And you can find the [Documentation for RestApi here](https://github.com/NitishGadangi/CovidAid/blob/master/backend/docs/api.md).

