1. [Example](#example)
2. [Example2](#example2)
3. [gfdgfds](#third-example)
4. [Fourth Example](#fourth-examplehttpwwwfourthexamplecom)



# Human Resources Management System

This is a kind of human resources management system back-end system simulation as monolithic architecture. You can register in the system as a **candidate** or an **employer**. Also you can add your own **cv** that contains many specifications like *schools*,  *job experience* etc. If you are an employer, you can publish a **job advertisement**. You can find the detailed explanation below.

### Technologies
- Spring Boot
- [Maildev (For simulating sending verification email)](https://maildev.github.io/maildev/)


## Example
## Example2



### Endpoints
- Users
    - Save Candidate
    - Save Employer
    - Save Employee
    - Find All Candidates
    - Find All Employers
    - Find All Employees
- Verification
    - Verify User
    - Resend Verification for Employer
    - Resend Verification for Candidate
- Confirmation
    - Confirm Employer
- Job Advertisement
    - Save Job Advertisement
    - Disable Job Advertisement
    - Find All Active Job Advertisements
    - Find All  Actve Job Advs Oredered By Date
    - Find All  Actve Job Advs By Company Name
- Job Position
    - Save Job Position
    - Find All Job Positions
- City
    - Save City
    - Find All Cities

## Third Example
## [Fourth Example](http://www.fourthexample.com)
##### Save Candidate
```
POST /candidates/savecandidate HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Content-Length: 214

{
    "email": "turgay@mail.com",
    "password": "123456",
    "passwordRepeat": "123456",
    "firstName": "turgay",
    "lastName": "cabalak",
    "identityNumber": "11111111111",
    "birthYear": 1991
```

- Cv
    - Save Cv
    - Add Education
    - Add Foreign Language
    - Add Job Experience
    - Add Skill
    - Find All Cvs By Candidate Id
- Language
    - Save Language
    - Find All Languages

