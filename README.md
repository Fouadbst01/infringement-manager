# Systèmes Distribués (SQRS & EVENT SOURCING) :blue_car:

## 1.Project Presentation
 * On souhaite créer un système distribué basé sur les micro-services en utilisant une architecture pilotée
par les événements respectant les deux patterns Event Sourcing et CQRS. Cette application devrait
permettre de gérer les infractions concernant des véhicules suites à des dépassement de vitesses
détectés par des radars automatiques. Le système se compose de trois micro-services :

    - Le micro-service qui permet de gérer les radars
    - Le micro-service d’immatriculation qui permet de gérer des véhicules appartenant des propriétaires
    - Le micro-service qui permet de gérer les infractions.

# Réalisation

### 1.	Architecture technique du projet CQRS & EVENT SOURCING:

![image](https://user-images.githubusercontent.com/70094556/209481234-212efa14-1251-4e29-8447-2485ac4f9f83.png)

### 2. Architecture du système :  

![image](https://user-images.githubusercontent.com/70094556/209481386-fdee71ee-e572-4795-a23a-e7268f1d5f13.png)

### 3. Développer le micro-service Radar 
 
![image](https://user-images.githubusercontent.com/70094556/209481485-0a2693b0-b4fb-45f9-a36d-9264113c2fdc.png)

### 4. Développer le micro-service radar-service-command-side (partie command)

![image](https://user-images.githubusercontent.com/70094556/209481530-8e3e5a3d-a6ac-4c9c-b09a-46b38f8d8850.png)

### 5. Développer le micro-service radar-service-query-side (partie query)

![image](https://user-images.githubusercontent.com/70094556/209481557-17b77071-34ef-49e9-85ae-7e042f6da1f2.png)

### 6. Développer le micro-service registration-service

![image](https://user-images.githubusercontent.com/70094556/209481636-0988e9c1-c2a1-4bbf-ac34-6b5bccbdac96.png)

### 7. Développer le micro-service registration-service-command

![image](https://user-images.githubusercontent.com/70094556/209481680-d73d1a70-089a-489c-b8d0-e9ae912921af.png)

### 8. Développer le micro-service registration-service-query

![image](https://user-images.githubusercontent.com/70094556/209481700-4f8db52b-94ba-40ff-a6ec-8ce770136b44.png)

### 9. Les services technique SPRING GATEWAY et Spring Cloud Discovery Eureka :

![image](https://user-images.githubusercontent.com/70094556/209481768-ca4ecb4a-b1b7-4907-bf84-eaeb50eeb089.png)

### 10. Les détails du micro service dans AXON SERVER UI:



