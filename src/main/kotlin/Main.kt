import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.sksamuel.scrimage.ImmutableImage
import com.sksamuel.scrimage.webp.WebpWriter
import java.io.File
import java.lang.Exception

@Composable
@Preview
fun App()
{
    Surface {
        Box(modifier = Modifier.fillMaxSize()) {
            Column(modifier = Modifier.fillMaxSize()) {
                Box(Modifier.width(500.dp).height(800.dp)) {
                    Text("test")
                }
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text("test")
                }
            }
        }
    }
}

val RESOURCESDIR = File(System.getProperty("compose.application.resources.dir"))

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
        shrink_image_file()
    }
}

fun shrink_image_file()
{
    println("RESOURCESDIR=" + RESOURCESDIR)
    try
    {
        val ff1 = File(RESOURCESDIR.canonicalPath + "/" + "background.jpg")
        val ff2 = File("/tmp/aa.webp")
        try
        {
            ff2.delete()
            // delete file to make sure its not from a previous run
        }
        catch(_: Exception)
        {
        }
        var new_len = ff1.length()
        val max_width = 800
        val qualityies = intArrayOf(70, 50, 30, 10, 4, 2, 1, 0)
        val count = 0
        val quality = qualityies[count]
        ImmutableImage.loader().fromFile(ff1).scaleToWidth(max_width).output(WebpWriter().withQ(quality), ff2.canonicalPath)
    }
    catch (e: Exception)
    {
        e.printStackTrace()
    }
}