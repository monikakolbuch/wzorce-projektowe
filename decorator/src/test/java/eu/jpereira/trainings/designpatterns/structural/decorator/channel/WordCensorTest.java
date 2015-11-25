package eu.jpereira.trainings.designpatterns.structural.decorator.channel;
 
 import static org.junit.Assert.assertEquals;
 
 import org.junit.Test;
 
 import eu.jpereira.trainings.designpatterns.structural.decorator.channel.SocialChannel;
 import eu.jpereira.trainings.designpatterns.structural.decorator.channel.SocialChannelBuilder;
 import eu.jpereira.trainings.designpatterns.structural.decorator.channel.SocialChannelProperties;
 import eu.jpereira.trainings.designpatterns.structural.decorator.channel.SocialChannelPropertyKey;
import eu.jpereira.trainings.designpatterns.structural.decorator.channel.decorator.AbstractSocialChanneldDecoratorTest;
import eu.jpereira.trainings.designpatterns.structural.decorator.channel.decorator.WordCensor;
import eu.jpereira.trainings.designpatterns.structural.decorator.channel.spy.TestSpySocialChannel;
 
 public class WordCensorTest extends AbstractSocialChanneldDecoratorTest {
 
 	@Test
 	public void testMessageWordCensor() {
 		SocialChannelBuilder builder = createTestSpySocialChannelBuilder();
 
 		SocialChannelProperties props = new SocialChannelProperties().putProperty(SocialChannelPropertyKey.NAME, TestSpySocialChannel.NAME);
 
 		SocialChannel channel = builder.with(new WordCensor("Microsoft")).getDecoratedChannel(props);// TODO
		channel.deliverMessage("Microsoft Windows is great!! ");
 		// Spy channel. Should get the one created before
 		TestSpySocialChannel spyChannel = (TestSpySocialChannel) builder.buildChannel(props);
		//assertEquals("### Windows is great!!", spyChannel.lastMessagePublished());
		assertEquals("### Windows is great!! ", spyChannel.lastMessagePublished());
 	}
 
 }