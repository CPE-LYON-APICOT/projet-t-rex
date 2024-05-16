# Pitch du projet
notre projet est un jeu facile à prendre en mains, de partie rapide mettant en valeur les aptitudes et reflexes du joueur. Inspiré du jeu de T-rex de Chrome, Shark est un jeu où un requin saute au dessus d'obstacles. l'objectif est de tenir le plus longtemps en esquivant les obstacles, tout en se ervant des power up et de s'adapter lorsqu'on reccoit des malus, pour rester en vie. le jeu n'a pas techniquement de fin. La difficulté augmente au fil du temps.

## TODO : Décrivez votre projet
Montrez qu'il mobilise des techniques de POO avancée
Comment allez-vous utiliser les patrons de conception ?
Comment allez-vous utiliser l'architecture MVC ?

Techniques de POO avancées
Classes et Objets :
GameModel.java : Gère l'état du jeu, les positions des obstacles, les power-ups, et la logique principale.
Obstacle.java : Représente les obstacles dans le jeu que le requin doit éviter.
Power.java : Gère les power-ups que le requin peut utiliser.
TRex.java : Gère les comportements spécifiques du personnage principal (requin), similaire au T-rex du jeu Chrome.
Encapsulation et Abstraction :
Chaque classe encapsule ses données et méthodes, fournissant une interface propre pour interagir avec d'autres parties du programme.
Utilisation des patrons de conception
Patron MVC (Modèle-Vue-Contrôleur) :

Modèle : GameModel.java gère les données et la logique du jeu.
Vue : GameView.java gère l'affichage du jeu, en utilisant des ressources comme cactus.png et teqshark.png.
Contrôleur : GameController.java gère les interactions utilisateur, comme les sauts du requin, et met à jour le modèle en conséquence.
Singleton :

Le contrôleur pourrait être implémenté comme un singleton pour garantir qu'il n'y a qu'une seule instance qui gère les événements du jeu.
Observer :

Le modèle (GameModel) peut notifier la vue (GameView) des changements, permettant une mise à jour réactive de l'interface utilisateur.
Factory :

La création d'obstacles et de power-ups pourrait être gérée par un pattern Factory pour une instanciation flexible et dynamique.
Exemple d'utilisation de l'architecture MVC
Modèle (GameModel.java) : Contient les données du jeu, telles que la position du requin, les obstacles, et les power-ups actifs.
Vue (GameView.java) : Affiche les éléments du jeu à l'écran en utilisant des images (comme cactus.png et teqshark.png).
Contrôleur (GameController.java) : Gère les entrées utilisateur (par exemple, les sauts du requin) et met à jour le modèle en conséquence.