package in.memoji.mi;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.util.SparseArray;
import android.widget.Toast;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;

/**
 * Created by mi on 20/12/17.
 */

public class Emojifier {
    static void detectFaces(Context context, Bitmap picture){

        //creating face detector with disabled face tracking and enabled face classification
        FaceDetector faceDetector = new FaceDetector.Builder( context )
                .setTrackingEnabled( false )
                .setClassificationType( FaceDetector.ALL_CLASSIFICATIONS ).build();


        //detecting faces in frames
        Frame frame = new Frame.Builder().setBitmap( picture ).build();
        SparseArray<Face> faces = faceDetector.detect( frame );

        if(faces.size()==0){
            Toast.makeText( context,"no faces", Toast.LENGTH_SHORT ).show();
        }
        Log.e( "No of faces: ", "" +faces.size() );

        faceDetector.release();
    }
}
