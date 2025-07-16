package com.sabcva.app

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sabcva.app.ui.theme.SABCVAAppTheme




@Composable
fun CreateAnnouncementScreen(modifier: Modifier = Modifier) {
    var selectedType by remember { mutableStateOf("Announcement") }
    var title by remember { mutableStateOf(TextFieldValue("")) }
    var description by remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Top Row: Admin + Post Button
        Text(
            text = "Admin Account",
            color = Color.Red,
            fontFamily = VietnamPro,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(4.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Create Announcement",
                fontSize = 18.sp,
                fontFamily = VietnamPro,
                color = Color(0xFF0D141C),
                fontWeight = FontWeight.Bold
            )

            TextButton(
                onClick = { /* handle post */ },
                modifier = Modifier.align(Alignment.CenterEnd)
            ) {
                Text("Post", fontFamily = VietnamPro, fontSize = 16.sp, color = Color(0xFF4A739C), fontWeight = FontWeight.Bold)
            }
        }

        Spacer(modifier = Modifier.height(0.dp))

        // Toggle Chips
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            listOf("Announcement", "Post", "Event").forEach { type ->
                OutlinedButton(
                    onClick = { selectedType = type },
                    shape = RoundedCornerShape(30),
                    border = BorderStroke(1.dp, Color.Black),
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = if (selectedType == type) Color.LightGray.copy(alpha = 0.4f) else Color.Transparent
                    ),
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 0.dp),
                    contentPadding = PaddingValues(horizontal = 12.dp, vertical = 4.dp)
                ) {
                    Text(text = type, fontFamily = VietnamPro, color = Color.Black, fontSize = 14.sp)
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Title Input
        TextField(
            value = title,
            onValueChange = { title = it },
            shape = RoundedCornerShape(12.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xFFE8EDF5),
                unfocusedContainerColor = Color(0xFFE8EDF5),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            placeholder = { Text("Title", color = Color(0xFF4A739C), fontFamily = VietnamPro)},
            modifier = Modifier
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Description Input
        TextField(
            value = description,
            onValueChange = { description = it },
            shape = RoundedCornerShape(12.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xFFE8EDF5),
                unfocusedContainerColor = Color(0xFFE8EDF5),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            placeholder = { Text("Description", color = Color(0xFF4A739C), fontFamily = VietnamPro) },
            modifier = Modifier
                .fillMaxWidth()
                .height(160.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Static Media Section
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    BorderStroke(
                        width = 1.dp,
                        color = Color(0xFFCFDBE8)
                    ),
                    shape = RoundedCornerShape(12.dp)
                )
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Upload Media",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Text(
                text = "Tap to select media for your post",
                fontSize = 14.sp,
                color = Color(0xFF0D141C),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 4.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Styled "Choose Media" Button (visual only)
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(50))
                    .background(Color(0xFFEFF2FA))
                    .padding(horizontal = 24.dp, vertical = 10.dp),
                contentAlignment = Alignment.Center // This centers the text inside the Box
            ) {
                Text(
                    text = "Choose Media",
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    fontSize = 14.sp,
                    modifier = Modifier.align(Alignment.Center) // Additional centering
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CreateAnnouncementScreenPreview() {
    SABCVAAppTheme {
        CreateAnnouncementScreen()
    }
}