package demo;

import com.intuit.karate.junit5.Karate;
 public class TestRunner{
 @Karate.Test
 Karate delete() {
  return Karate.run("featureFile/delete").relativeTo(getClass());
 }
 @Karate.Test
 Karate get() {return Karate.run("featureFile/get").relativeTo(getClass());}
  @Karate.Test
 Karate patch() {return Karate.run("featureFile/patch").relativeTo(getClass());}
  @Karate.Test
 Karate post() {return Karate.run("featureFile/post").relativeTo(getClass());}
  @Karate.Test
 Karate put() {return Karate.run("featureFile/put").relativeTo(getClass());}

}