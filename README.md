# Coding Challenge

### As per the requirement in this assessment candidate will be tasked with filling out the functionality of different methods that will be listed further down.

These methods will require some level of api interactions with the following base url: https://dummy.restapiexample.com. But when i tried to access this base url it was always failing
so i created one EmployeeServer code which returns the output same like this base URL.
https://github.com/absawant25/EmployeeServer/tree/master

So i would suggest first run this code and its base URL will be http://localhost:8081/employees for accessing it. And also i have added this as a external base URL in application.properties.

I have also added swagger-ui so that one can get one view of all the supported api calls in this project,
http://localhost:8080/swagger-ui/


### Endpoints to implement

getAllEmployees()

    output - list of employees
    description - this should return all employees

getEmployeesByNameSearch()

    output - list of employees
    description - this should return all employees whose name contains or matches the string input provided

getEmployeeById(string id)

    output - employee
    description - this should return a single employee

getHighestSalaryOfEmployees()

    output - integer of the highest salary
    description -  this should return a single integer indicating the highest salary of all employees

getTop10HighestEarningEmployeeNames()

    output - list of employees
    description -  this should return a list of the top 10 employees based off of their salaries

createEmployee(string name, string salary, string age)

    output - string of the status (i.e. success)
    description -  this should return a status of success or failed based on if an employee was created

deleteEmployee(String id)

    output - the name of the employee that was deleted
    description - this should delete the employee with specified id given

### External endpoints from base url

#### This section will outline all available endpoints and their request and response models from http://localhost:8080/swagger-ui/

/employee

    request:
        method: GET
        parameters: n/a
        full route: http://localhost:8080/employee
    response:
        {
            [
                {
                "id": "1",
                "employee_name": "Tiger Nixon",
                "employee_salary": "320800",
                "employee_age": "61",
                "profile_image": ""
                },
                ....
            ]
        }

/employee/{id}

    request:
        method: GET
        parameters: 
            id (String)
        full route: http://localhost:8080/employee/{id}
    response: 
        {            
            "id": "1",
            "employee_name": "Foo Bar",
            "employee_salary": "320800",
            "employee_age": "61",
            "profile_image": ""            
        }

/create

    request:
        method: POST
        parameters: 
            name (String),
            salary (String),
            age (String)
        full route: http://localhost:8080/employee
    response:
        {            
            "name": "test",
            "salary": "123",
            "age": "23",
            "id": 25        
        }

/delete/{id}

    request:
        method: DELETE
        parameters:
            id (String)
        full route: http://localhost:8080/employee/{id}
    response:
        {            
            "message": "successfully! deleted Record"
        }