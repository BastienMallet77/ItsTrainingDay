package sopra.projet.ItsTrainingDay.model;

public class Views {
	
	public static class ViewCommon{}
	
		public static class ViewDegree extends ViewCommon {}
			public static class ViewDegreeDetail extends ViewDegree{}
			
		public static class ViewErole extends ViewCommon {}
			public static class ViewEroleDetail extends ViewErole{}
			
		public static class ViewExercice extends ViewCommon {}
			public static class ViewExerciceDetail extends ViewExercice{}
			
		public static class ViewInProgress extends ViewCommon {}
			public static class ViewInProgressDetail extends ViewInProgress{}
			
		public static class ViewLevel extends ViewCommon {}
			public static class ViewLevelDetail extends ViewLevel{}
			
		public static class ViewProgram extends ViewCommon {}
			public static class ViewProgramDetail extends ViewProgram{}
			
		public static class ViewSession extends ViewCommon {}
			public static class ViewSessionDetail extends ViewSession{}
			
		public static class ViewSpecialisation extends ViewCommon {}
			public static class ViewSpecialisationDetail extends ViewSpecialisation{}
			
		public static class ViewSport extends ViewCommon {}
			public static class ViewSportDetail extends ViewSport{}
			
		public static class ViewUser extends ViewCommon {}
			public static class ViewUserDetail extends ViewUser{}
}
