import UIKit
import SwiftUI
import ComposeApp

struct ComposeView: UIViewControllerRepresentable {
    
    let vm: HelloViewModel
    
    init(vm: HelloViewModel) {
        self.vm = vm
    }
    
    func makeUIViewController(context: Context) -> UIViewController {
        MainViewControllerKt.MainViewController(viewModel: vm)
    }
    
    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}

struct ComposeView2: UIViewControllerRepresentable {
    
    let vm: HelloViewModel
    
    init(vm: HelloViewModel) {
        self.vm = vm
    }
    
    func makeUIViewController(context: Context) -> UIViewController {
        MainViewControllerKt.MainViewController2(viewModel: vm)
    }
    
    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}

struct ContentView: View {
    let vm = HelloViewModel()
    
    var body: some View {
        TabView {
            NavigationStack() {
                VStack {
                    ComposeView(vm: vm)
                }
            }
            .tabItem {
                Label("Screen 1", systemImage: "play.tv.fill")
            }
            
            NavigationStack() {
                VStack {
                    ComposeView2(vm: vm)
                }
            }
            .tabItem {
                Label("Screen 2", systemImage: "flag.checkered")
            }
            
        }
        
        .ignoresSafeArea(.keyboard) // Compose has own keyboard handler
    }
}
