
# Human Resources Management System

This is a kind of human resources management system back-end system simulation as monolithic architecture. You can register in the system as a **candidate** or an **employer**. Also you can add your own **cv** that contains many specifications like *schools*,  *job experience* etc. If you are an employer, you can publish a **job advertisement**. You can find the detailed explanation below.

### Technologies

- Spring Boot
- Maven
- [Maildev (For simulating sending verification email)](https://maildev.github.io/maildev/)

#### Some Information About Project

The system mainly contains 3 kinds of users that you can be  registered which are job seeker, employer or employee. 
For candidates there is an email verification. After confirming the email sent to the email address they used for registration, they can create and save, update or delete their own cv to the system.
For employers there is one more confirmation manually made by employees. After these two stages are approved, they can add a job posting to the system.
<hr>

### Endpoints
- [Users](#users)
    - [Save Candidate](#save-candidate)
    - [Save Employer](#save-employer)
    - [Save Employee](#save-employee)
    - [Find All Candidates](#find-all-candidates)
    - [Find All Employers](#find-all-employers)
    - [Find All Employees](#find-all-employees)
- [Verification](#verification)
    - [Verify User](#verify-user)
    - [Resend Verification for Employer](#resend-verification-employer)
    - [Resend Verification for Candidate](#resend-verification-candidate)
- [Confirmation](#confirmation)
    - [Confirm Employer](#confirm-employer)
- [Job Advertisement](#job-advertisement)
    - [Save Job Advertisement](#save-job-advertisement)
    - [Disable Job Advertisement](#disable-job-advertisement)
    - [Find All Active Job Advertisements](#find-all-active-job-advertisements)
    - [Find All  Actve Job Advertisements Oredered By Date](#find-all-active-job-advertisements-oredered-by-date)
    - [Find All  Active Job Advertisements By Company Name](#find-all-active-job-advertisements-by-company-name)
- [Job Position](#job-position)
    - [Save Job Position](#save-job-position)
    - [Find All Job Positions](#find-all-job-positions)
- [City](#city)
    - [Save City](#save-city)
    - [Find All Cities](#find-all-cities)
- [Cv](#cv)
    - [Save Cv](#save-cv)
    - [Add Education](#add-education)
    - [Add Foreign Language](#add-foreign-language)
    - [Add Job Experience](#add-job-experience)
    - [Add Skill](#add-skill)
    - [Find All Cvs By Candidate Id](#find-all-cvs-by-candidate-id)
- [Language](#language)
    - [Save Language](#save-language)
    - [Find All Languages](#find-all-languages)
<hr>

#### Users
##### Save Candidate
```
POST /candidates/savecandidate HTTP/1.1
Host: localhost:8080
Content-Type: application/json

{
    "email": "example@mail.com",
    "password": "123456",
    "passwordRepeat": "123456",
    "firstName": "examplefname",
    "lastName": "examplelname",
    "identityNumber": "11111111111",
    "birthYear": 1991
```
##### Find All Candidates
```
GET /candidates/findallcandidates HTTP/1.1
Host: localhost:8080
```
##### Save Employee
```
POST /employees/saveemployee HTTP/1.1
Host: localhost:8080
Content-Type: application/json

{
    "email": "ayaz@mail.com",
    "password": "123456",
    "passwordRepeat": "123456",
    "firstName": "examplefname",
    "lastName": "examplelname"
}
```
##### Find All Employees
```
GET /employees/findallemployee HTTP/1.1
Host: localhost:8080
```
##### Save Employer
```
POST /employers/saveemployer HTTP/1.1
Host: localhost:8080
Content-Type: application/json

{
    "companyName": "example company name",
    "website": "www.examplecompany.com",
    "email": "abc@examplecompany.com",
    "password": "123456",
    "passwordRepeat": "123456",
    "phoneNumber": "1111111"
}
```
##### Find All Employers
```
GET /employers/findallemployers HTTP/1.1
Host: localhost:8080
```
<hr>

#### Verification
##### Verify User
```
GET /verification/verify?code=exampleToken HTTP/1.1
Host: localhost:8080
```
##### Resend Verification Employer
```
GET /verification/reproduceverificationemployer?email=abc@example.com HTTP/1.1
Host: localhost:8080
```
##### Resend Verification Candidate
```
GET /verification/reproduceverificationemployer?email=abc@example.com HTTP/1.1
Host: localhost:8080
```
<hr>

#### Confirmation
##### Confirm Employer
```
GET /confirmations/confirmemployer?confirmationId=1&employeeId=1 HTTP/1.1
Host: localhost:8080
```
<hr>

#### Job Advertisement
##### Save Job Advertisement
```
POST /jobadvertisements/savejobadvertisement HTTP/1.1
Host: localhost:8080
Content-Type: application/json

{
    "jobPositionId": 1,
    "jobDescription": "example description",
    "cityId": 1,
    "minSalary": 1000,
    "maxSalary": 1000,
    "openPositionNumber": 1,
    "deadLine": "2022-05-05",
    "employerId": 1
}
```
##### Disable Job Advertisement
```
GET /jobadvertisements/disablejobadvertisement?jobAdvertisementId=1&employerId=1 HTTP/1.1
Host: localhost:8080
```
##### Find All Active Job Advertisements
```
GET /jobadvertisements/findallactivejobadvertisements HTTP/1.1
Host: localhost:8080
```
##### Find All Active Job Advertisements Oredered By Date
```
GET /jobadvertisements/findallactivejobadvertisements HTTP/1.1
Host: localhost:8080
```
##### Find All Active Job Advertisements By Company Name
```
GET /jobadvertisements/findallactivejobadvertisementsbycompanyname?companyName=example HTTP/1.1
Host: localhost:8080
```
<hr>

#### Job Position
##### Save Job Position
```
POST /jobpositions/addjobposition?positionName=example HTTP/1.1
Host: localhost:8080
```
##### Find All Job Positions
```
GET /jobpositions/findalljobpositions HTTP/1.1
Host: localhost:8080
```
<hr>

#### City
##### Save City
```
POST /cities/addcity?cityName=example HTTP/1.1
Host: localhost:8080
```
##### Find All Cities
```
GET /cities/findallcities HTTP/1.1
Host: localhost:8080
```
<hr>

#### Cv
##### Save Cv
```
POST /cvs/savecv2 HTTP/1.1
Host: localhost:8080
Content-Type: application/json

{
    "candidateId": 1,
    "photo": "photoURL",
    "coverLetter": "example",
    "gitHub": "githubURL",
    "linkedIn": "linkedInURL"
}
```
##### Add Education
```
POST /cvs/addeducation?cvId=1 HTTP/1.1
Host: localhost:8080
Content-Type: application/json

{
    "schoolName": "example",
    "department": "example",
    "startDate": "2022-05-05",
    "endDate": "2022-05-05"
}
```
##### Add Foreign Language
```
POST /cvs/addforeignlanguage?cvId=1 HTTP/1.1
Host: localhost:8080
Content-Type: application/json

{
    "languageId": 1,
    "level": 1
}
```
##### Add Job Experience
```
POST /cvs/addjobexperience?cvId=1 HTTP/1.1
Host: localhost:8080
Content-Type: application/json

{
    "jobPositionId": 1,
    "companyName": "example",
    "startDate": "2022-05-05",
    "endDate": "2022-05-05"
}
```
##### Add Skill
```
POST /cvs/addskill?cvId=1 HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Content-Length: 46

{
    "skill": "example",
    "skillLevel": 1
}
```
##### Find All Cvs By Candidate Id
```
GET /cvs/cvsbycandidateid?candidateId=1 HTTP/1.1
Host: localhost:8080
```
<hr>

#### Language
##### Save Language
```
POST /languages/addlanguage?languageName=example HTTP/1.1
Host: localhost:8080
```
##### Find All Languages
```
GET /languages/findallanguages HTTP/1.1
Host: localhost:8080
```
