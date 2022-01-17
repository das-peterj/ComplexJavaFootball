# Installation instructions for DOCKER

- Click on Maven in IntelliJ on the right sidebar. Then click on package.
- Open Powershell
- Navigate to the right map with, cd
- ``Docker image build -t football-project .``
- ``Docker image ls`` (To check if there's any image)
- ``Docker container run -p 8080:8080 football-project``
___
# Endpoints
Base url http://localhost:8080

## - Create (POST):
    - /sponsor
      - {
        "name" : "Coca cola"
        }
    - /managers
      - {
        "fullName" : "Mourinho",
        "phoneNumber" : "072289582",
        "age" : "50",
        "email" : "morran@roma.com",
        "userName" : "morre",
        "password" : "roma"
        }
    - /teams
      - {
        "name" : "PSG",
        "teamValue" : "1245m"
        }
    - /players
      - {
        "fullName" : "Alex Isak",
        "position" : "Striker",
        "marketValue" : "50m",
        "userName" : "alexx",
        "password" : "xlesa"
        }
    - /owners
      - {
        "fullName" : "PeterJ",
        "netWorth" : "10m",
        "phoneNumber" : "0725158242",
        "age" : "19",
        "userName" : "karamba",
        "password" : "124"
        }
    - /leagues
      - {
        "leagueName" : "PremierLeauge",
        "country" : "England"
        }
    - /users
        - {
	"name" : "Lionel Messi",
	"userName" : "messi",
	"password" : "psg" }
      

## - Read (GET):
    - /sponsors
        - /sponsors/{id}
    - /managers
        - /managers/{id}
    - /teams
        - /teams/{id}
    - /players
        - /players/{id}
    - /owners
        - /owners/{id}
    - /leagues
        - /leagues/{id}
    - /users
        -/users/createAdmin/{userName}

## - Update (PUT):
    -/sponsors/{sponsor_id}/addSponsorToTeam/{team_id}
    -/managers/{manager_id}/addManagerToTeam/{team_id}
    -/teams/{team_id}/addTeamToLeague/{league_id}
    -/players/{player_id}/addPlayerToTeam/{team_id}
    -/owners/{owner_id}/addOwnerToTeam/{team_id}

## - Delete (DELETE)
    - /sponsors/{id}
    - /managers/{id}
    - /teams/{id}
    - /players/{id}
    - /owners/{id}
    - /leagues/{id}
___

Muharem & Peter & Oscar

