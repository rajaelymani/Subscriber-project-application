# Subscriber project application

## Technologies 
```bash
+ Java 8
+ Spring boot 
+ Maven 
+ Base de données H2
+ TestUnitaire Junit
+ Postman 
+ Intelij 
+ Git
```

## Se connecter a la BD

Connectez vous sur URL : 
```bash
http://localhost:8080/h2-console/
```

utilisez les informations suivantes pour se connecter: 
```bash
+ JDBC URL : jdbc:h2:mem:TEST
+ User Name  : sa
+ Password : 
```

Au niveau de notre BD, on 3 tables qui représentent les entités de notre projet : 
+ SUBSCRIBER 
cette entité représente l'abboné 
+ CONTRACT
cette entité représente les contrats liés à chaque abonné 
+ MVT_HISTORY  
cette entité représente l'historique des modifications d'adresse principal d'un abonné et l'adresse de ses contrats 

## L'architecture du projet 

### database 
#### dao.entity
on a 3 entitées : 
###### Subscriber 
Cette entité représente l'abonné, chaque abonné à 
+ Son id, prenom , nom et adresse principale 
+ Constructeur de l'entité et les getter et setter 

###### Contract 
Cette entité représente le contract 
+ Chaque abonné peut avoir plusieur contrats 
+ Relation ManyToOne entre contrat et l'abonné : un abonné peut avoir plusieurs contrats, chaque contrat est lié à un abonné et l'adresse principale de l'abonné est la meme que l'adresse pour les contrats liés à cet abonné   
+ Chaque contrat à son id, son adresss (qu'est l'adresse principale de l'abonné) et  un abonné 
+ Constructeur de l'entité et les getter et setter 

###### MvtHistory 
Cette entité représente les modifications faites au niveau de l'adresse principale de l'abonné 
+ cette entité "MvtHistory" à son id, id de l'abonné pour lequel la modification d'adresse est faite, id du contrat pour lequel la modifcation est faite, type de modification qu'est une modification d'adresse, la date de la modification, l'ancienne valeur et la nouvelle valeur de l'adresse 
+ Constructeur de l'entité et les getter et setter 

#### dao.repository
on a 3 repository :
###### SubscriberRepository
Définit la méthode "getSubscriber" :
La méthode retourne un abonné, en le cherchant avec son id au niveau de la BD 

###### ContractRepository 
Définit la méthode "getAllContractBySubscriberId" : 
La méthode retourne une liste des contrats liés à un abonné, en cherchat sur la base par l'id de l'abonné 

###### MvtHistoryRepository
Définit la méthode "MvtHistoryRepository" : 
La méthode retourne une liste des modifications faites sur l'adresse d'un abonné, en cherchant sur la BD par son id

### controller 
#### Interface
###### ISubscriberController
Défini 4 API (url : http://localhost:8080/subscribers)

+ getAllSubscribers : Get API , path : http://localhost:8080/subscribers
En appelant cette API, on a la liste des abonnés 


+ retrieveSubscriber : Get API , path : http://localhost:8080/subscribers/{id}
En appelant cette API, avec un id, on aura les informations de l'abonné qui a cet id 

+ addSubscriber : Post API , path : http://localhost:8080/subscribers/addSubscriber
En appelant cette API, en envoyant le profile d'un abonné sous format JSON, on le ajoute au niv de la DB

+ updateAdressSubscriber : Post API , path : http://localhost:8080/subscribers/updateAdressSubscriber/{subscriberId}/{newAdress}
En appelant cette API, en envoyant l'id de l'abonné et son nouvelle adresse, on modifie l'ancienne adresse par la nouvelle 


###### IContractController
Défini 1 API (url : http://localhost:8080/contracts)

+ addContract : Get API , path : http://localhost:8080/contracts/{subscriberId}
En appelant cette API, en envoyant l'id de l'abonné et un contrat sous format JSON, on joute le nouveau contrat et l'abonné au quel il est lié 

###### IMvtHistoryController
Défini 1 API (url : http://localhost:8080/mvtHistory)

+ getMvtHistoryBySubscriberId : Get API , path : http://localhost:8080/mvtHistory/{subscriberId}
En appelant cette API, en envoyant l'id de l'abonné on aura la liste des modifications d'adresse faites pour cet abonné sous format d'hystorique 

#### Implémentation

L'implémentation des 6 API pour les 3 interfaces  

### dépendances utilisées 

+ springframework
+ h2database
+ junit

### test 

#### API 







## pour plus d'informations : rajae.lymani@gmail.com
