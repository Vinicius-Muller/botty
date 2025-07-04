pub fn exec() {
	let list:[String; 2] = [String::from("vinicius"), String::from("priscila")];
	
	for name in &list {
		println!("User: {}", name);
	}

	drop(list);
}
