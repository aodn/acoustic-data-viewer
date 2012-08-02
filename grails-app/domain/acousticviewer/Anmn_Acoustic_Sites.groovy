package acousticviewer

class Anmn_Acoustic_Sites {

	Integer id
	String name
	String code
	String spec_url
	
	// this is linking to DB view table. 
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
	  table 'anmn_acoustic_sites'
      id    column:'pkid'
        

   } 
}
