/*
 * (c) 2018-2019 Charles-Philip Bentley
 * This code is licensed under MIT license (see LICENSE.txt for details)
 */
package pasa.cbentley.jpasc.swing.tests;

import java.util.ArrayList;
import java.util.Locale;

import pasa.cbentley.core.src4.helpers.BasicPrefs;
import pasa.cbentley.core.src4.interfaces.IPrefs;
import pasa.cbentley.core.src4.logging.BaseDLogger;
import pasa.cbentley.core.src4.logging.IDLogConfig;
import pasa.cbentley.core.src4.logging.ITechLvl;
import pasa.cbentley.core.src4.logging.ITechTags;
import pasa.cbentley.core.src5.ctx.C5Ctx;
import pasa.cbentley.jpasc.pcore.ctx.ITechPCore;
import pasa.cbentley.jpasc.pcore.ctx.PCoreCtx;
import pasa.cbentley.jpasc.swing.ctx.PascalSwingCtx;
import pasa.cbentley.swing.SwingPrefs;
import pasa.cbentley.swing.ctx.SwingCtx;
import pasa.cbentley.swing.gif.ctx.SwingGifCtx;
import pasa.cbentley.swing.images.ctx.ImgCtx;
import pasa.cbentley.testing.engine.TestCaseBentley;

public abstract class TestJPascSwingAbstract extends TestCaseBentley {

   protected PCoreCtx       pc;

   protected SwingCtx       sc;

   protected PascalSwingCtx psc;

   /**
    * Log Config
    */
   protected IDLogConfig    config;

   private ImgCtx           imgc;

   private SwingGifCtx      gifc;

   /**
    * by default hides sysout when test is valid
    */
   public TestJPascSwingAbstract() {
   }

   public void setupAbstract() {

      setUpNoConnection();

      BasicPrefs prefs = new BasicPrefs(uc);
      pc.setPrefs(prefs);
      //don't auto lock wallet on connection
      prefs.putBoolean(ITechPCore.PKEY_AUTO_LOCK, false);
      pc.getRPCConnection().connectLocalhost();
   }

   public void setUpNoConnection() {
      BaseDLogger loggerFirst = (BaseDLogger) uc.toDLog();
      config = loggerFirst.getDefault().getConfig();
      config.setLevelGlobal(ITechLvl.LVL_03_FINEST);
      config.setFlagTag(ITechTags.FLAG_17_PRINT_TEST, true);
      C5Ctx c5 = new C5Ctx(uc);
      sc = new SwingCtx(c5);
      pc = new PCoreCtx(uc, c5);
      imgc = new ImgCtx(sc);
      gifc = new SwingGifCtx(sc, imgc);
      psc = new PascalSwingCtx(pc, sc, gifc);

      BasicPrefs prefs = new BasicPrefs(uc);
      pc.setPrefs(prefs);

      sc.setPrefs(prefs);

      //we need to load strings in the bundle
      ArrayList<String> list = new ArrayList<String>();
      sc.addI18NKey(list);
      psc.addI18NKey(list);
      pc.addI18NKey(list);
      gifc.addI18NKey(list);
      sc.setBundleList(list);

      String language = "en";
      String country = "US";
      Locale currentLocale = new Locale(language, country);
      sc.setLocale(currentLocale);
   }

}
