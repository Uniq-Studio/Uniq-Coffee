package org.uniqstudio.uniqcoffee.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.uniqstudio.uniqcoffee.R
import org.uniqstudio.uniqcoffee.ui.TopAppBar

@Composable
fun AboutCreatorScreenApp(onClickBack: () -> Unit) {
    Column {
        TopAppBar(R.string.about, onClickBack)
    }

        PersonalInfo(
            R.drawable.user_profile,
            R.string.full_name,
            R.string.title,
            Modifier
        )

        SocialInfo(
            R.string.number,
            R.string.socials,
            R.string.email
        )
}

@Composable
fun PersonalInfo (profilePicX: Int, fullName: Int, title: Int, modifier: Modifier){
    Column(
        //Placing the view in the center, lifting it up a bit with bottom padding
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(bottom = 150.dp)
    ) {
        Image(
            //Profile picture with a smaller size
            painter = painterResource(profilePicX),
            contentDescription = null,
            modifier.size(150.dp)
        )
        Text(
            //Displays name in very thin font
            stringResource(fullName),
            fontSize = 50.sp,
            fontWeight = FontWeight.ExtraLight
        )
        Text(
            //Displays title in thick, light gray font
            stringResource(title),
            fontSize = 15.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color.LightGray
        )
    }
}

@Composable
fun SocialInfo (phoneNumber: Int, socialHandle: Int, emailAddress: Int){
    Column(
        //Placing view at bottom middle
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Column(
            modifier = Modifier.padding(bottom = 30.dp)
        ) {
            //Phone Number
            Row(
                modifier = Modifier.padding(bottom = 20.dp)
            ) {
                Image(
                    painterResource(R.drawable.broken_phone),
                    contentDescription = null
                )
                Text(
                    stringResource(phoneNumber),
                    modifier = Modifier.padding(start = 20.dp)
                )
            }

            //Socials
            Row(
                modifier = Modifier.padding(bottom = 20.dp)
            ) {
                Image(
                    painterResource(R.drawable.broken_share),
                    contentDescription = null
                )
                Text(
                    stringResource(socialHandle),
                    modifier = Modifier.padding(start = 20.dp)
                )
            }

            //Email
            Row(
                modifier = Modifier.padding(bottom = 20.dp)
            ) {
                Image(
                    painterResource(R.drawable.broken_mail),
                    contentDescription = null
                )
                Text(
                    stringResource(emailAddress),
                    modifier = Modifier.padding(start = 20.dp)
                )
            }

        }

    }
}