package pasa.cbentley.jpasc.swing.models.tests;

import pasa.cbentley.jpasc.swing.models.ComboModelMapPublicKeyJava;
import pasa.cbentley.jpasc.swing.models.ModelProviderPublicJavaKeyPrivate;
import pasa.cbentley.jpasc.swing.tests.TestJPascSwingAbstract;

public class TestModelProviderPublicJavaKeyPrivate extends TestJPascSwingAbstract {

   
   public void testCreate() {
      
      ModelProviderPublicJavaKeyPrivate model = new ModelProviderPublicJavaKeyPrivate(psc);
      
   }
   
   public void testGenerate() {
      
      ModelProviderPublicJavaKeyPrivate model = new ModelProviderPublicJavaKeyPrivate(psc);
    
      ComboModelMapPublicKeyJava createModelPublicKeyJava = model.createModelPublicKeyJava();
      
      
   }
}
