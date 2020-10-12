# CovidAid

## The elevator pitch
A mobile application where people can make requests asking for help, and other members of the community close to them can accept any request and provide help.

## Inspiration
The idea stems from an experience a fellow teammate had. His neighbors got infected with COVID19 and 3 out of the 4 members of the household had to be admitted to a hospital at a different location, leaving the oldest member of the household alone and without the ability to ask for help from the community (because he was supposed to be in isolation) in case he needed anything.

Globally, similar problems are being faced, be it due to the virus or because of the disruption to modern life, a lot of people are in need of help and have no way to communicate their problems to the community to get the help they need.

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
