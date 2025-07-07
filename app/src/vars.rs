use std::io;

pub fn run() {
	const TERMINAL_ID: i8 = 10;
	let mut  name = String::new();
	let mut age = String::new();

	println!("Terminal: {}", TERMINAL_ID);

	println!("Enter your name:");

	io::stdin().read_line(&mut name).expect("Failed to write name");

	println!("Hello {}", name);

	println!("Please tell me you age");

	io::stdin().read_line(&mut age).expect("Failed to write age");

	println!("Great, you have {} of age", age);
}
