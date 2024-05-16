
# Retro-conception

**Binome 1 : [Villeroy de Galhau Côme]**
**Binome 2 : [Zoppini Maxime]**

Complétez ce document pour décrire votre projet, les difficultés rencontrées, les design patterns mis en oeuvre, les améliorations possibles, et en quoi la POO vous a été utile.

> **Faites le avec sérieux, ce document ainsi que votre code seront évalués.**
Si vous considérez que votre code est quasi-parfait, je vais chercher les erreurs et en trouver, et cela vous pénalisera.
Si vous êtes critique envers vous-même et que vous expliquez correctement vos difficultés, vous serez "à moitié" pardonné.

Ce n'est pas grave de ne pas avoir été au bout de ce que vous vouliez faire, comportez vous comme un ingénieur qui doit rendre des comptes à son client, et qui doit expliquer pourquoi il n'a pas pu tout faire.
Pour rappel le client n'est pas un developpeur (sinon il ne vous aurait pas payé une fortune pour le faire à sa place), vous devez lui expliquer de manière simple et claire les problèmes rencontrés, en vous justifiant 
>Imaginez que vous avez codé Mortal Kombat 
Ne dites pas "je n'ai pas eu le temps de tout faire", mais plutôt "j'ai préféré me concentrer sur la création des spectaculaires "Finish Him" des personnages car c'est un élément essentiel du gameplay, cependant la difficulté dynamique en fonction de la maîtrise du joueur n'a pas pu être implémentée à temps, compte tenu que les critères de maîtrises sont difficilement modélisables, toutefois nous pourrions envisager d'implémenter que plus le combat dure longtemps, plus les coups portés sont puissants, ce qui est rapide à implémenter et lors d'une mise à jour, nous pourrions remplacer ce système par quelque chose de plus élaboré"

Aussi, en entreprise, vous serez confronté à des programmes très mal codés, et vous allez galérer à les comprendre, vous risquez d'essayer de les corriger et tomber dans les mêmes ecueils que les développeurs précédents.
Pour cela, il est courrant de tenir un jour un Document d'Architecture Technique (DAT) qui explique comment fonctionne le programme, et comment le reprendre ainsi qu'un document de réversibilité qui explique comment reprendre le code de quelqu'un d'autre.
(C'est obligatoire pour les marchés publics de prévoir une réversibilité, c'est à dire que le client peut vous dégager et une autre entreprise doit pouvoir reprendre votre code sans difficulté)
Dans ces documents, il ne s'agit pas de cacher la poussière sous le tapis, il faut être honnête et proposer une vision d'ensemble de votre code, et expliquer pourquoi vous avez fait des choix, et pourquoi vous n'avez pas fait d'autres choix, il est souvent question de compromis (on fait un truc pas ouf pour gagner du temps, mais la qualité du code en pâtit, etc.)
> Vous pouvez dire : "Pour la gestion des collisions, nous utilisons une librairie tierce, toutefois celle-ci ne gère que les collisions entre des rectangles, au fur et à mesure des itérations, des ennemis de grande taille et de forme complexe sont apparus, toutefois, nous avons conservé une hitbox rectangulaire, en résulte que le joueur peut être touché alors que visuellement, il n'est pas en contact avec l'ennemi ; nous avions également envisagé de créer plusieurs hitbox de tailles différentes sur un même ennemi afin de mieux coller à la forme de celui-ci, toutefois, les performances du jeu ont étés trop dégradées"



---
# Partie "Client" (pas trop technique) :

## Objectif du projet

L'objectif initial du projet était de créer un jeu qui est inspiré par le jeu du T-Rex de Google Chrome avec des fonctionnalités supplémentaires pour rendre le jeu plus intéressant et engageant. Nous voulions que le T-Rex soit un requin dessiné par nous-même, qu'il puisse acquérir des pouvoirs spéciaux après avoir atteint certains scores, améliorant ainsi la jouabilité et la dynamique du jeu.

## Résultat

Nous avons atteint une grande partie de notre objectif. Le jeu de base fonctionne comme prévu, avec le requin qui court et saute pour éviter des obstacles. Nous avons également implémenté des pouvoirs spéciaux qui s'activent après avoir atteint certains scores, offrant des périodes d'immunité qui durent 5 secondes. 

### Améliorations possibles

Nous aurions pu si y avait plus de temps ajouter les powers qui sont des malus et ajouter des obstacles dans le ciel. On aurait aussi pu mettre en place un système pour le score et faire en sorte de retenir les scores précédents pour qu'il y ait des records à battre.

---
# Partie "Développeur" (plus technique) :


### Implémentations remarquables

Nous sommes particulièrement fiers de l'implémentation des pouvoirs dans le jeu. La classe Power permet une gestion facile et extensible des différents types de pouvoirs. Chaque pouvoir a une durée de vie et un état actif, ce qui permet de les activer et de les désactiver facilement, et la manière dont nous avons codé l'application nous permet de pouvoir ajouter des choses avec une certaine facilité.

### Faiblesses du code

- Gestion des collisions : actuellement, les collisions sont gérées de manière basique avec des hit box rectangulaires. Cela peut entraîner des situations où les collisions ne semblent pas réalistes.

- Code monolithique : certaines partie du code, notamment la gestion des obstacles, pourraient être mieux modulaires pour faciliter l'extension et la maintenance.

### Difficultés rencontrées

#### 1. [Génération dynamique des obstacles pour fluidifier]

Nous avons eu des difficultés a fluidifié notre jeu, car il manquait de FPS au début. Mais nous avons essayé de faire plusieurs méthodes pour gérer ce souci notamment avec un écouteur qui supprimait les obstacles une fois le requin passé.

#### 2. [Implémentation des images créer par nous même]

Nous avons fait le choix de faire nous-même les images de notre jeu et nous ne connaissions pas la librairie swing donc nous avons du découvrir comment cela marchait.


### *Design Patterns* mis en oeuvre

#### 1. [Factory]

Nous avons utilisé le pattern Factory pour créer des instances d'obstacles de manière dynamique. Cela nous permet d'ajouter facilement de nouveaux types d'obstacles à l'avenir sans modifier le code existant.

<pre>
```java
public class ObstacleFactory {
    public static Obstacle createObstacle(int xPosition) {
        // Vous pouvez ajouter ici des conditions pour créer différents types d'obstacles
        return new Obstacle(xPosition);
    }
}
```
</pre>


---
# Partie pédagogique


### En quoi la POO vous a été utile

La programmation orientée objet (POO) nous a permis de structurer notre code de manière modulaire et extensible. Grâce à la POO, nous avons pu créer des classes distinctes pour les différentes entités du jeu (TRex, Obstacle, Power), ce qui a simplifié la gestion des interactions entre ces entités. Par exemple, l'utilisation de la classe TRex a facilité la modélisation de notre personnage et la gestion des pouvoirs spéciaux. De plus, la POO a permis une meilleure utilisation du code, rendant le projet plus facile à maintenir et à étendre.

### Conclusion

Ce projet nous a permis de mieux comprendre les concepts de la POO et leur application dans un projet de jeu vidéo. Nous avons appris l'importance de structurer le code de manière modulaire et avons vu les avantages de l'utilisation des design patterns pour résoudre des problèmes courants. Bien que nous n'ayons pas pu implémenter toutes les fonctionnalités que nous avions envisagées, nous avons réussi à créer un jeu fonctionnel et extensible, et nous avons identifié des pistes d'amélioration pour l'avenir.