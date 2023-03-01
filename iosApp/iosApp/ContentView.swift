import SwiftUI
import SharedSDK

struct ContentView: View {
    
    var viewModel = LoginViewModel()

	var body: some View {
		Text("greet")
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
