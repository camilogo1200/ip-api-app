## Note:
Due to time constraints, and personal situations, I couldn't link the main project. I suggest using the UI.demo project to run the solution.

## Constraints (Views Framework):
- Due to some business decisions and aligned to the current tech stack of the company, the project was done using the old Views framework on Android, not Jetpack Compose

## Application Icon
<img src="https://github.com/camilogo1200/ip-api-app/assets/456256/dd9c54ed-b8ff-4060-85bd-33345e1ffdea" width="250px"/>


## Location Permissions Request ( for tracking user changes on location)
<img src="https://github.com/camilogo1200/ip-api-app/assets/456256/f751d283-c436-4fad-ad52-f3e4066abdba" width="350px"/>

## Main Screen (Query Screen)
<img src="https://github.com/camilogo1200/ip-api-app/assets/456256/15c35c46-205d-42bb-8435-44e29474423c" width="350px"/>

## History Screen
<img src="https://github.com/camilogo1200/ip-api-app/assets/456256/380da7f1-754b-42ed-83ae-f371d2a69e78" width="350px"/>


# Description

![image](https://github.com/camilogo1200/ip-api-app/assets/456256/c063b818-4bb7-419c-8364-5bf26e8d7a7c)


- Multi-module project focused on modularity, and independent workloads, that result in  much easier releases for the different components of the application.
- Clean Architecture and domain-centric approach
- UI, Domain, Data
- MVVM - MVI
- Kotlin Flows & Coroutines
- DI Using Dagger Hilt
- Navigation using navigation component, Nested navigation graphs, and global actions

## Navigation

### Main Navigation
![image](https://github.com/camilogo1200/ip-api-app/assets/456256/bd399481-664b-4a18-a9b3-250122172989)

## Main Nested Dashboard Navigation Graph (With Global actions)

![image](https://github.com/camilogo1200/ip-api-app/assets/456256/32d497e4-8c17-40fa-91e9-1fc091502f73)

### Typical UI folder organization
![image](https://github.com/camilogo1200/ip-api-app/assets/456256/0c434da6-4dbd-4333-a2f8-95042053e42c)

### Database module ( module view )
![image](https://github.com/camilogo1200/ip-api-app/assets/456256/67162f4b-f3b1-447d-84ac-ab937880e865)

### Network Module
![image](https://github.com/camilogo1200/ip-api-app/assets/456256/d88a2810-d983-4812-b9af-7dc85fad209e)

## Common Module (Utils module) 
![image](https://github.com/camilogo1200/ip-api-app/assets/456256/e57f6bd3-1f57-4066-add2-bca80dc1f595)



## Tech Stack 

### Jetpack Libraries
- View binding
- Data binding
- Navigation component
- ViewModel
- ViewPager
- Room
- Lifecycles
- Hilt

### Asynchronity 
- Suspend functions
- Kotlin Coroutines
- Kotlin Flows

### Network ( network module )
- Retrofit
- OkHttp

### Serialization
- KotlinX.Serialization

## Modules
