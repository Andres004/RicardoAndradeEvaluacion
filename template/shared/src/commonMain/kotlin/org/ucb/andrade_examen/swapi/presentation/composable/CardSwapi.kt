package org.ucb.andrade_examen.swapi.presentation.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import org.ucb.andrade_examen.swapi.domain.model.SwapiModel

@Composable
fun CardSwapi(model: SwapiModel) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = model.name,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Altura: ${model.height}", style = MaterialTheme.typography.bodySmall)
            Text(text = "Peso: ${model.mass}", style = MaterialTheme.typography.bodySmall)
            Text(text = "Género: ${model.gender}", style = MaterialTheme.typography.bodySmall)
            Text(text = "Cabello: ${model.hairColor}", style = MaterialTheme.typography.bodySmall)
            Text(text = "Ojos: ${model.eyeColor}", style = MaterialTheme.typography.bodySmall)
            Text(text = "Piel: ${model.skinColor}", style = MaterialTheme.typography.bodySmall)
        }
    }
}