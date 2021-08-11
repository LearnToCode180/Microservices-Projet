# Microservices-Project
Conception et implementation d'une application qui fait la **gestion des ressources matérielles** des différents départements d’une faculté en respectant **l'architecture des microservices** avec le framework **Spring Boot**.

# Problématique
Le travail commence lorsqu’un département a un budget pour l’achat de **ressources**, le chef du département doit demander aux enseignants du département d’envoyer leurs **besoins** en termes de matériels. Après, le chef envoie ces besoins au responsable pour qu’il fasse un **appel d’offre**. Après les **soumissions** des **fournisseurs**. Le responsable doit pouvoir éliminer les mauvais fournisseurs, ceux qui n’ont pas respecté scrupuleusement leurs engagements auparavant, et leur envoyer le **motif** de leur élimination. Le chef du département doit aussi envoyer au responsable, la liste prévue des **affectations** des **ressources** en fonction des personnes du département. Les personnes des départements peuvent signaler au service de maintenance toute **panne** qui survient dans leurs **ressources**. Le service de maintenance peut alors intervenir auprès du département, son **constat** sera envoyé automatiquement au responsable qui doit l’envoyer par email au **fournisseur** de cette **ressource** lorsqu’il s’agit d’un défaut matériel et que la durée de garantie n’est pas encore terminée.

# Acteurs
Voici les différents acteurs de l’application :
+ Employé (appartient à un département)
+ Chef de département
+ Responsable de ressources
+ Service de maintenance
+ Fournisseur

# Microservices
Il y a dix microservices :

+ Microservice d'Authentification
+ Microservice des Fournisseurs
+ Microservice des Besoins
+ Microservice des Appels d'offres
+ Microservice des Affectations
+ Microservice des Ressources
+ Microservice des Maintenances
+ Microservice des Constats
+ Microservice des Motifs
+ Microservice des Soumissions





