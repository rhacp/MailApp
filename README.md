# MailApp

The `application.properties` has to be added with the according credentials:

```
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=
spring.mail.password=
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true

```

### Objective: 

Create a REST API that allows users to create an account, and another one that allows users to check the account created.

### Requirements:
An user account should have as properties:<br /><br />
Unique identifier (this should be automatically generated by the server)<br />
First name<br />
Last name<br />
Email address<br />
Date and time when his account was created (this should be automatically generated by the server)<br /><br />

After the user sends a request to the server to create an account, the server should send an email to the user’s email address, and inform him/her that the account was successfully created.<br />

### Validations we should consider:

first/last name should not be empty/null or < 2 characters<br />
Email address should have a valid email address (domain@something.extension) <br />

---

## Team Members

- [Gabriella Nuca](https://github.com/GabriellaNuca2209)
- [Anghel Andrei](https://github.com/rhacp)
- [Dan Ionescu](https://github.com/Daniel7Ionescu)
