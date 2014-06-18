package org.redpill.maven.alfresco;

import java.util.Map.Entry;
import java.util.Properties;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Component;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

@Mojo(name = "set-properties", defaultPhase = LifecyclePhase.VALIDATE, threadSafe = true)
public class PropertiesMojo extends AbstractMojo {

  @Parameter(required = true)
  private Properties properties;

  @Component
  private MavenProject project;

  public void execute() throws MojoExecutionException, MojoFailureException {
    for (Entry<Object, Object> property : properties.entrySet()) {
      project.getProperties().setProperty(property.getKey().toString(), property.getValue().toString());
    }
  }

}
