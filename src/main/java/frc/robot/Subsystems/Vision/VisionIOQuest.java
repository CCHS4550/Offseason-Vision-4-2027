package frc.robot.Subsystems.Vision;

import edu.wpi.first.math.geometry.Transform3d;
import frc.robot.Subsystems.Vision.VisionIO.VisionIOInputs;
import java.util.ArrayList;

public class VisionIOQuest implements VisionIO {
  private QuestNavSubsystem questNav;
  private Transform3d robotToQuestTransform;

  public VisionIOQuest(QuestNavSubsystem questNav) {
    this.questNav = questNav;
  }

  @Override
  public void updateInputs(VisionIOInputs inputs) {
    inputs.connected = questNav.getConnected();
    ArrayList<PoseObservation> questPoseObservation = new ArrayList<>();

    questPoseObservation.add(
        new PoseObservation(
            questNav.getTimestamp(),
            questNav.getPose3d().transformBy(robotToQuestTransform.inverse()),
            0.0,
            0,
            null,
            0,
            PoseObservationType.QUESTNAV));
  }
}
