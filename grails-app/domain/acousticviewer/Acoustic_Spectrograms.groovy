package acousticviewer

class Acoustic_Spectrograms {

	
	Integer id
	Integer acousticDeployFk 
	String filename
	String subdirectory
	Integer width
	Date timeStart
	
	
   transient beforeInsert = {
      throw new RuntimeException('create not allowed')
   }
   transient beforeUpdate = {
      throw new RuntimeException('update not allowed')
   }
   transient beforeDelete = {
      throw new RuntimeException('delete not allowed')
   }
	
   static mapping = {
      cache usage: 'read-only'
      version false
	  table 'acoustic_spectrograms'
      id    column:'pkid', generator:'sequence', params:[sequence:'anmn_acoustic_spectrograms_pkid_seq']     

   } 
    static constraints = {
		
    }
}
