package com.example.profil.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.profil.R
import com.example.profil.data.Project
import com.example.profil.data.Skill
import com.example.profil.ui.theme.ProfilTheme

/** Avatar circulaire avec un badge de disponibilité superposé grâce à Box. */
@Composable
fun AvatarWithBadge(
    isAvailable: Boolean,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.size(112.dp)) {
        Image(
            painter = painterResource(R.drawable.ic_avatar),
            contentDescription = "Photo de profil",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .clip(CircleShape)
                .border(3.dp, MaterialTheme.colorScheme.primary, CircleShape)
        )
        Surface(
            shape = CircleShape,
            color = if (isAvailable) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.outline,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .size(28.dp)
                .border(3.dp, MaterialTheme.colorScheme.surface, CircleShape)
        ) {}
    }
}

/** En-tête du profil : avatar, nom, rôle et disponibilité. */
@Composable
fun ProfileHeader(
    name: String,
    role: String,
    availability: String,
    isAvailable: Boolean,
    modifier: Modifier = Modifier
) {
    Surface(
        color = MaterialTheme.colorScheme.primaryContainer,
        contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
        shape = MaterialTheme.shapes.large,
        modifier = modifier.fillMaxWidth()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(24.dp)
        ) {
            AvatarWithBadge(isAvailable = isAvailable)
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = name,
                style = MaterialTheme.typography.headlineMedium,
                textAlign = TextAlign.Center
            )
            Text(
                text = role,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(12.dp))
            Surface(
                color = MaterialTheme.colorScheme.tertiaryContainer,
                contentColor = MaterialTheme.colorScheme.onTertiaryContainer,
                shape = MaterialTheme.shapes.small
            ) {
                Text(
                    text = availability,
                    style = MaterialTheme.typography.labelLarge,
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
                )
            }
        }
    }
}

/** Titre de section accompagné d'une icône. */
@Composable
fun SectionTitle(
    title: String,
    @DrawableRes icon: Int,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Icon(
            painter = painterResource(icon),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge
        )
    }
}

/** Élément de la LazyRow des compétences. */
@Composable
fun SkillCard(
    skill: Skill,
    modifier: Modifier = Modifier
) {
    Card(
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
            contentColor = MaterialTheme.colorScheme.onSecondaryContainer
        ),
        modifier = modifier.width(140.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = skill.name,
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = skill.level,
                style = MaterialTheme.typography.labelMedium
            )
        }
    }
}

/** Élément de la liste des projets. */
@Composable
fun ProjectCard(
    project: Project,
    modifier: Modifier = Modifier
) {
    Card(
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = project.title,
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = project.period,
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = project.description,
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = project.technologies.joinToString(" · "),
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.secondary
            )
        }
    }
}

/** Information structurée affichée dans un champ en lecture seule. */
@Composable
fun ReadOnlyInfoField(
    label: String,
    value: String,
    @DrawableRes icon: Int,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = value,
        onValueChange = {},
        readOnly = true,
        singleLine = true,
        label = { Text(label) },
        leadingIcon = { Icon(painter = painterResource(icon), contentDescription = null) },
        shape = MaterialTheme.shapes.small,
        modifier = modifier.fillMaxWidth()
    )
}

/** Zone de contact : informations en lecture seule et actions principales. */
@Composable
fun ContactSection(
    email: String,
    location: String,
    onContactClick: () -> Unit,
    onDownloadCvClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        shape = MaterialTheme.shapes.large,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
        modifier = modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            ReadOnlyInfoField(label = "Email", value = email, icon = R.drawable.ic_email)
            Spacer(modifier = Modifier.height(8.dp))
            ReadOnlyInfoField(label = "Localisation", value = location, icon = R.drawable.ic_location)
            Spacer(modifier = Modifier.height(16.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Button(
                    onClick = onContactClick,
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_send),
                        contentDescription = null,
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Contacter")
                }
                OutlinedButton(
                    onClick = onDownloadCvClick,
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_download),
                        contentDescription = null,
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("CV")
                }
            }
        }
    }
}

@Preview(showBackground = true, name = "SkillCard")
@Composable
fun SkillCardPreview() {
    ProfilTheme {
        SkillCard(skill = Skill("Kotlin", "Intermédiaire"), modifier = Modifier.padding(8.dp))
    }
}

@Preview(showBackground = true, name = "ProjectCard")
@Composable
fun ProjectCardPreview() {
    ProfilTheme {
        ProjectCard(
            project = Project(
                title = "Profil développeur",
                period = "2026",
                description = "Application Compose affichant une fiche de profil.",
                technologies = listOf("Kotlin", "Compose")
            ),
            modifier = Modifier.padding(8.dp)
        )
    }
}
