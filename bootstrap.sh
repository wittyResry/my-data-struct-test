set -eux

cd build-tools/bazel/
sudo apt-get update -qq
sudo apt-get install -y protobuf-compiler libarchive-dev netcat-traditional
sudo update-alternatives --set nc /bin/nc.traditional

# unistall
#sudo apt-get remove openjdk*
# bazel install
#sudo echo "deb http://ppa.launchpad.net/webupd8team/java/ubuntu xenial main" | sudo tee /etc/apt/sources.list.d/webupd8team-java.list
#sudo echo "deb-src http://ppa.launchpad.net/webupd8team/java/ubuntu xenial main" | sudo tee -a /etc/apt/sources.list.d/webupd8team-java.list
#sudo apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv-keys EEA14886
#sudo apt-get update && sudo apt-get install oracle-java8-installer
#echo "deb [arch=amd64] http://storage.googleapis.com/bazel-apt stable jdk1.8" | sudo tee /etc/apt/sources.list.d/bazel.list
#curl https://bazel.build/bazel-release.pub.gpg | sudo apt-key add -
#sudo apt-get update && sudo apt-get install bazel
sudo apt-get install pkg-config zip g++ zlib1g-dev unzip python
sudo wget https://github.com/bazelbuild/bazel/releases/download/0.14.1/bazel-0.14.1-installer-linux-x86_64.sh
sudo chmod +x bazel-0.14.1-installer-linux-x86_64.sh
sudo ./bazel-0.14.1-installer-linux-x86_64.sh --user



export JAVA_HOME=/usr/lib/jvm/java-8-oracle
export JAVA_OPTS="-Xmx3000m"
uname -a
echo $PATH
java -version
wget https://github.com/bazelbuild/bazel/releases/download/0.3.1/bazel_0.3.1-linux-x86_64.deb
sudo dpkg -i bazel_0.3.1-linux-x86_64.deb

bazel build //src:bazel


BAZEL=build-tools/bazel/output/bazel
cd ../..
ln -s build-tools/bazel/tools .
ln -s build-tools/bazel/third_party .
$BAZEL fetch //java/...
