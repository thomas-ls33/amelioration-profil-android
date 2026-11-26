package com.example.profil.data

data class Skill(
    val name: String,
    val level: String
)

data class Project(
    val title: String,
    val period: String,
    val description: String,
    val technologies: List<String>
)

data class DeveloperProfile(
    val name: String,
    val role: String,
    val description: String,
    val isAvailable: Boolean,
    val availability: String,
    val email: String,
    val location: String,
    val skills: List<Skill>,
    val projects: List<Project>
)

// Données locales écrites directement dans le code
val thomasProfile = DeveloperProfile(
    name = "Thomas Laas",
    role = "Développeur Android junior",
    description = "Étudiant en informatique, je développe des applications Android avec " +
        "Kotlin et Jetpack Compose. Je cherche une alternance pour progresser sur des projets réels.",
    isAvailable = true,
    availability = "Disponible pour une alternance",
    email = "thomasou.laas@gmail.com",
    location = "France",
    skills = listOf(
        Skill("Kotlin", "Intermédiaire"),
        Skill("Jetpack Compose", "Intermédiaire"),
        Skill("Material 3", "Débutant"),
        Skill("Git", "Intermédiaire"),
        Skill("Java", "Débutant"),
        Skill("SQL", "Débutant")
    ),
    projects = listOf(
        Project(
            title = "Profil développeur",
            period = "2026",
            description = "Application Compose affichant une fiche de profil avec thème clair et sombre.",
            technologies = listOf("Kotlin", "Compose", "Material 3")
        ),
        Project(
            title = "Liste de tâches",
            period = "2025",
            description = "Petite application de gestion de tâches réalisée en cours de développement mobile.",
            technologies = listOf("Kotlin", "Android")
        ),
        Project(
            title = "Site portfolio",
            period = "2025",
            description = "Site personnel présentant mes projets étudiants et mon parcours.",
            technologies = listOf("HTML", "CSS", "JavaScript")
        )
    )
)

val camilleProfile = DeveloperProfile(
    name = "Camille Martin",
    role = "Développeuse full-stack freelance",
    description = "Cinq ans d'expérience sur des applications web et mobiles, de l'API au front.",
    isAvailable = false,
    availability = "Indisponible avant janvier",
    email = "camille.martin@example.com",
    location = "Lyon",
    skills = listOf(
        Skill("TypeScript", "Avancé"),
        Skill("Node.js", "Avancé"),
        Skill("PostgreSQL", "Intermédiaire"),
        Skill("Docker", "Intermédiaire")
    ),
    projects = listOf(
        Project(
            title = "Plateforme de réservation",
            period = "2024 – 2025",
            description = "API REST et interface web pour un réseau de salles de sport.",
            technologies = listOf("Node.js", "React", "PostgreSQL")
        ),
        Project(
            title = "Application de livraison",
            period = "2023",
            description = "Suivi de commandes en temps réel pour une épicerie locale.",
            technologies = listOf("Kotlin", "Firebase")
        )
    )
)
