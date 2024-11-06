package project.nerdlab.logintheme

import android.os.Bundle
import android.renderscript.Sampler.Value
import android.text.InputType
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.InspectableProperty
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import org.intellij.lang.annotations.Language
import project.nerdlab.logintheme.ui.theme.LoginThemeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginScreen()
        }
    }
}

@Composable
fun LoginScreen(){
    Column (
        modifier = Modifier.fillMaxSize()
            .padding(26.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.End,
    ) {
        Languages()
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text =  "Login",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(
            modifier = Modifier.height(4.dp)
        )
        Text(
            text = "You must login into your\n account to continue",
            textAlign = TextAlign.Center
        )



    Spacer(
        modifier = Modifier.height(60.dp)
    )



        InputBox("E-mail")

        Spacer(
            modifier = Modifier.height(4.dp)
        )

        InputBox("Password")


        Spacer(
            modifier = Modifier.height(16.dp)
        )

       Button(
           onClick = {},
           colors = ButtonDefaults.buttonColors(Color.Yellow),
           shape = RoundedCornerShape(10.dp),
           modifier = Modifier.size(280.dp, 50.dp)
       ) {
           Text(
               text = "Login",
               color = Color.Black,
               fontSize = 15.sp,
               fontWeight = FontWeight.Medium

           )

       }

        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ){

            val checkedRememberMe = remember { mutableStateOf(false) }

            Checkbox(
                checked = checkedRememberMe.value,
                onCheckedChange = { checkedRememberMe.value = it },
            )

            Text(
                text = "Remember Me",
                fontSize = 18.sp
            )

            Spacer(modifier = Modifier.width(24.dp))

            Text(
                text =  "Register",
                fontSize = 18.sp,
                modifier = Modifier.clickable {  }
            )
        }

        Spacer(modifier = Modifier.height(14.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {

            HorizontalDivider(
                modifier = Modifier.width(100.dp)
            )

            Text(
                text = "or",
                modifier = Modifier.padding(20.dp)
            )

            HorizontalDivider(
                modifier = Modifier.width(100.dp)
            )
        }


        Row (
            modifier = Modifier.padding(start = 35.dp, end = 35.dp, bottom = 20.dp)
        ){
            SocialLogin()
        }

        Row {
            Text(
                text =  "Not Registered?",
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.width(5.dp))

            Text(
                text =  "Register",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable {  }
            )
        }

        Spacer(
            modifier = Modifier.height(16.dp)
        )


    }


}

@Composable
fun Languages(){
    var dropDown by remember { mutableStateOf(false) }

    // Create a list of cities
    val mLang = listOf("English", "French", "Spanish", "Japanese")

    var mSelectedText by remember { mutableStateOf("") }


    val icon = if (dropDown)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown

    Column(Modifier.padding(20.dp)) {


        OutlinedTextField(
            value = mSelectedText,
            onValueChange = { mSelectedText = it },
            modifier = Modifier
                .width(140.dp),
            label = {Text("English")},
            trailingIcon = {
                Icon(icon,"contentDescription",
                    Modifier.clickable { dropDown = !dropDown })
            }
        )


    }
}



@Composable
fun InputBox(name: String){
    Column {
        Text(
            text = "$name",
//            inputType = "$inputType"
        )
        OutlinedTextField(
            value = "",
            onValueChange = {}
        )
    }
}


@Composable
fun SocialLogin(){
    Image(
        painter = painterResource(id = R.drawable.google),
        contentDescription = "Google",
        modifier = Modifier.clickable {  }
            .clip(RoundedCornerShape(10.dp))
            .border(BorderStroke(width = 0.5.dp, color = Color.Black), shape = RoundedCornerShape(10.dp))
            .padding(start = 35.dp, end = 35.dp, top = 4.dp, bottom = 4.dp)
            .size(30.dp)




    )

    Spacer(
        modifier = Modifier.width(12.dp)
    )

    Image(
        painter = painterResource(id = R.drawable.apple),
        contentDescription = "Apple",

        modifier = Modifier.clickable {  }
            .clip(RoundedCornerShape(10.dp))
            .border(BorderStroke(width = 0.5.dp, color = Color.Black), shape = RoundedCornerShape(10.dp))
            .padding(start = 35.dp, end = 35.dp, top = 4.dp, bottom = 4.dp)
            .size(30.dp)


    )

}


@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}


// End of Code

