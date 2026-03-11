// MediaPlayerScreen.kt
@Composable
fun MediaPlayerScreen() {
    var isPlaying by remember { mutableStateOf(false) }
    var currentPosition by remember { mutableStateOf(0f) }
    var volume by remember { mutableStateOf(70f) }
    
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF0f172a),
                        Color(0xFF1e293b)
                    )
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Album Cover
            Card(
                modifier = Modifier
                    .size(320.dp)
                    .padding(top = 32.dp),
                shape = RoundedCornerShape(16.dp),
                elevation = CardDefaults.cardElevation(8.dp)
            ) {
                AsyncImage(
                    model = "album_cover_url",
                    contentDescription = "Album Cover",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }
            
            // Song Info
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(vertical = 24.dp)
            ) {
                Text(
                    text = "Midnight Drive",
                    style = MaterialTheme.typography.headlineMedium,
                    color = Color.White
                )
                Text(
                    text = "Electric Dreams",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.Gray
                )
            }
            
            // Progress Bar
            Column {
                Slider(
                    value = currentPosition,
                    onValueChange = { currentPosition = it },
                    modifier = Modifier.fillMaxWidth(),
                    colors = SliderDefaults.colors(
                        thumbColor = Color(0xFF3b82f6),
                        activeTrackColor = Color(0xFF3b82f6)
                    )
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("1:23", color = Color.Gray, fontSize = 12.sp)
                    Text("3:45", color = Color.Gray, fontSize = 12.sp)
                }
            }
            
            // Controls
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 24.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { }) {
                    Icon(
                        Icons.Filled.SkipPrevious,
                        contentDescription = "Previous",
                        tint = Color.White,
                        modifier = Modifier.size(48.dp)
                    )
                }
                
                FloatingActionButton(
                    onClick = { isPlaying = !isPlaying },
                    containerColor = Color(0xFF3b82f6),
                    modifier = Modifier.size(72.dp)
                ) {
                    Icon(
                        if (isPlaying) Icons.Filled.Pause else Icons.Filled.PlayArrow,
                        contentDescription = "Play/Pause",
                        tint = Color.White,
                        modifier = Modifier.size(36.dp)
                    )
                }
                
                IconButton(onClick = { }) {
                    Icon(
                        Icons.Filled.SkipNext,
                        contentDescription = "Next",
                        tint = Color.White,
                        modifier = Modifier.size(48.dp)
                    )
                }
            }
            
            // Volume Control
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 32.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    Icons.Filled.VolumeUp,
                    contentDescription = "Volume",
                    tint = Color.Gray
                )
                Slider(
                    value = volume,
                    onValueChange = { volume = it },
                    valueRange = 0f..100f,
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 16.dp),
                    colors = SliderDefaults.colors(
                        thumbColor = Color(0xFF3b82f6),
                        activeTrackColor = Color(0xFF3b82f6)
                    )
                )
                Text(
                    text = "${volume.toInt()}",
                    color = Color.Gray,
                    fontSize = 14.sp,
                    modifier = Modifier.width(32.dp)
                )
            }
        }
    }
}
