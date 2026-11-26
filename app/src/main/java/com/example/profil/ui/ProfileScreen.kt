package com.example.profil.ui

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.profil.R
import com.example.profil.data.DeveloperProfile
import com.example.profil.data.camilleProfile
import com.example.profil.data.thomasProfile
import com.example.profil.ui.components.ContactSection
import com.example.profil.ui.components.ProfileHeader
import com.example.profil.ui.components.ProjectCard
import com.example.profil.ui.components.SectionTitle
import com.example.profil.ui.components.SkillCard
import com.example.profil.ui.theme.ProfilTheme

@Composable
fun ProfileScreen(
    profile: DeveloperProfile,
    onContactClick: () -> Unit,
    onDownloadCvClick: () -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(16.dp)
) {
    // Une seule LazyColumn pour tout l'écran : les projets sont des items, le reste des sections
    LazyColumn(
        contentPadding = contentPadding,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier.fillMaxSize()
    ) {
        item {
            ProfileHeader(
                name = profile.name,
                role = profile.role,
                availability = profile.availability,
                isAvailable = profile.isAvailable
            )
        }

        item {
            Text(
                text = profile.description,
                style = MaterialTheme.typography.bodyLarge
            )
        }

        item { SectionTitle(title = "Compétences", icon = R.drawable.ic_code) }

        item {
            LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                items(profile.skills, key = { it.name }) { skill ->
                    SkillCard(skill = skill)
                }
            }
        }

        item { SectionTitle(title = "Projets", icon = R.drawable.ic_code) }

        items(profile.projects, key = { it.title }) { project ->
            ProjectCard(project = project)
        }

        item { SectionTitle(title = "Contact", icon = R.drawable.ic_email) }

        item {
            ContactSection(
                email = profile.email,
                location = profile.location,
                onContactClick = onContactClick,
                onDownloadCvClick = onDownloadCvClick
            )
        }
    }
}

@Preview(showBackground = true, name = "Profil – clair", heightDp = 1400)
@Composable
fun ProfileScreenLightPreview() {
    ProfilTheme(darkTheme = false) {
        Surface(color = MaterialTheme.colorScheme.background) {
            ProfileScreen(profile = thomasProfile, onContactClick = {}, onDownloadCvClick = {})
        }
    }
}

@Preview(
    showBackground = true,
    name = "Profil – sombre",
    heightDp = 1400,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun ProfileScreenDarkPreview() {
    ProfilTheme(darkTheme = true) {
        Surface(color = MaterialTheme.colorScheme.background) {
            ProfileScreen(profile = thomasProfile, onContactClick = {}, onDownloadCvClick = {})
        }
    }
}

@Preview(showBackground = true, name = "Full-stack indisponible", heightDp = 1200)
@Composable
fun ProfileScreenFullStackPreview() {
    ProfilTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            ProfileScreen(profile = camilleProfile, onContactClick = {}, onDownloadCvClick = {})
        }
    }
}
