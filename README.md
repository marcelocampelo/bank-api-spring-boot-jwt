# bank-api-spring-boot-jwt
A simple checking account REST API secured by jwt (JSON web token)

url_base:http://localhost:8080/

## SERIVCES SUMMARY

	SERVICES 	| ENDPOINTS | METHODS | BODY OBJECTS | RESPONSE 200 OBJECTS

1 - User Registration 	| /users    | POST | email, password, name | email, name |

2 - Authentication	| /auth     | POST | email, password | name, email, token |

3 - Create Account	| /accounts | POST | number, balance | number, balance, user{} |

4 - Transfer Money	| /accounts/transfer 	| POST | source'\_account'\_number, destination'\_account'\_number, amount|

5 - Show Balance	| /accounts/balance	| POST | account'\_number | account'\_number, balance | 

All services regarding accounts have as part of the header the {"Authorization": "Bearer TOKEN"} -> TOKEN in this case being the one returned at the auth endpoint.
