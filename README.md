# CovidAid

## The elevator pitch
A mobile application where people can make requests asking for help, and other members of the community close to them can accept any request and provide help.

## Inspiration
COVID19 has drastically affected people's lives around the globe. There are a lot of people in need of help but don't have a platform to effectively communicate their requests to the community around them. For people affected by the virus it becomes twice as worse because they would be in isolation and cannot communicate if they are in distress with others. This problem is compounded in smaller cities, where you usually don't have service for grocery or medicine delivery apps.

In these trying times, as we come together to battle this virus, there have been countless instances of people reaching out and helping each other. The objective with CovidAid is to facilitate the ease with with someone in need of help can request for help and can be helped out by others.


## What it does
CovidAid is a community-driven platform for the people. On it, people looking to help others can locate people that need help and fulfill their request with mutual consent, based on their location and proximity. Every user can do either of two things:
1. **Ask for help** - This is for help-seekers. They can make requests by filling out details of what they would like help with and each new request is then posted onto a timeline for everyone to see.
2. **Like to help** - This is for people who would like to help. They will be presented with a number of active requests, which they can look through and accept as they see fit.

For each request they complete, helpers will score points and the top helpers can be seen on the leaderboard.

## Screenshots
{Nitish}

## How it was built

**Frontend**
{Nitish}

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

**Frontend**
{Nitish}

**Backend**

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
