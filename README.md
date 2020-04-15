# DNS Challenge

---
#### Implementation of an DNS API.

The code for this REST API was developed in the Java language, with the Spring Boot framework and the MySQL database.

---

#### Importing the project on your IDE

To run this project, you can clone this repository on the IDE of your choice and the MAVEN will download all dependencies and build the project.


Before running the project, you must change your database's user and password information on this project.
To do this, open the file:

	application.properties on the folder -> src/main/resources/
	

When running the project, your database will be created and populated with initial data, by the Flyway migration tool.


You can download the REST API tests, which I created and shared on Postman.

You can download/import in following link:

[https://www.getpostman.com/collections/b8bbcfafba19ebe445e9](https://www.getpostman.com/collections/b8bbcfafba19ebe445e9)

---

#### Using the API

###### The URL for requests is
	
	http://localhost:8080/dns/
	
	
###### Searching a DNS Record by entering it's Id on URL

	http://localhost:8080/dns/1
	
	
###### Searching a DNS Record by JSON on the Body of the request
	
Set on the Headers of your REST API Testing Tool (like Postman)

	Content-Type: application/json

Set the HTTP request method to GET and paste your JSON on the Body with this format

	{
		"included" : ["ipsum.com", "dolor.com"],
		"excluded" : ["sit.com"],
		"page" : 1
	}
	
As a response you will receive a JSON with this format

	{
		"totalNumberOfMatchingDnsRecords": 2,
		"matchingDnsRecords": [
			{
				"id": "1",
				"ip": "1.1.1.1"
			},
			{
				"id": "3",
				"ip": "3.3.3.3"
			}
		],
		"hostnamesAssociatedWithMatchingDnsRecords": [
			{
				"hostname": "lorem.com",
				"numberOfMatchingDnsRecords": "1"
			},
			{
				"hostname": "ipsum.com",
				"numberOfMatchingDnsRecords": "2"
			},
			{
				"hostname": "dolor.com",
				"numberOfMatchingDnsRecords": "2"
			},
			{
				"hostname": "amet.com",
				"numberOfMatchingDnsRecords": "2"
			}
		]
	}
	
	
###### Adding a new DNS Record 

Set on the Headers of your REST API Testing Tool (like Postman)

	Content-Type: application/json

Set the HTTP request method to Post and paste your JSON on the Body with this format

	{
		"ip": "1.1.1.1",
		"hostnames" : ["lorem.com", "ipsum.com", "dolor.com", "amet.com"]
	}
	
As a response you will receive a JSON with this format
	
	{
		"id": 6,
		"ip": "1.1.1.1",
		"hostnames": [
			"lorem.com",
			"ipsum.com",
			"dolor.com",
			"amet.com"
		]
	}
	
Note that you also received the Location on Headers of the response